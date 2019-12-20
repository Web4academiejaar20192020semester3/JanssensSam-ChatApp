package controller;

import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = ((Person)(request.getSession().getAttribute("user")));
        person.setStatus(request.getParameter("status"));
        return person.getStatus();
    }
}