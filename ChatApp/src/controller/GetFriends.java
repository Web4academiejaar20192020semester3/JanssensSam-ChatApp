package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.ArrayList;

public class GetFriends extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person) request.getSession().getAttribute("user");
        ArrayList<Person> friendsList = new ArrayList<>();
        for(int i = 0; i < user.getFriends().size(); i++){
            friendsList.add(getPersonService().getPerson(user.getFriends().get(i)));
        }

        Gson gson = new Gson();
        String json = gson.toJson(friendsList);
        return json;
    }
}
