package controller;

import com.google.gson.Gson;
import domain.Message;
import domain.MessageService;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;

public class Chat extends RequestHandler {
    MessageService messageService;
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response){
        messageService = this.getMessageService();
        Person user = (Person) request.getSession().getAttribute("user");
        String receiver = request.getParameter("receiver");
        String newContent = request.getParameter("content");
        Gson gson = new Gson();
        String json = "";
        if (newContent != null){
            Message message = gson.fromJson(newContent, Message.class);
            message.setSender(user.getUserId());
            int newIndex = 0;
            for (Message m : getUserChat(user.getUserId(), receiver)) {
                if (m.getIndex() > newIndex) {
                    newIndex = m.getIndex();
                }
            }
            newIndex++;
            message.setIndex(newIndex);
            messageService.addMessage(message);
            receiver = message.getReceiver();
            System.out.println(gson.toJson(message));
        }
        if (user != null && receiver != null) {
            response.setContentType("application/json");
            json = gson.toJson(getUserChat(user.getUserId(), receiver));

        }

        return json;

    }

    private ArrayList<Message> getUserChat(String userId, String receiver) {
        ArrayList<Message> newMessages = new ArrayList<>();

        for (Message m : messageService.getAll()) {
            if ((m.getSender().equals(userId) && m.getReceiver().equals(receiver)) || (m.getSender().equals(receiver) && m.getReceiver().equals(userId))) {
                newMessages.add(m);
            }
        }
        Collections.sort(newMessages);
        return newMessages;
    }
}
