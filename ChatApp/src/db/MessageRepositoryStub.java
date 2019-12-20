package db;

import domain.Message;

import java.util.ArrayList;

public class MessageRepositoryStub implements MessageRepository {
    private ArrayList<Message> messages = new ArrayList<>();

    public MessageRepositoryStub() {
        messages.add(new Message("an@ucll.be","jan@ucll.be","Ja hoor! Met jou ook?",1));
        messages.add(new Message("jan@ucll.be","an@ucll.be","Hallo, alles goed?",0));
    }

    @Override
    public ArrayList<Message> getAll() {
        return messages;
    }

    @Override
    public void addMessage(Message message) {
        messages.add(message);
    }
}
