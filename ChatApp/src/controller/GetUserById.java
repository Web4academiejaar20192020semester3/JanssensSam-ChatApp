package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@WebServlet("/GetUserById/*")
public class GetUserById extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PersonService personService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /*@Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.addHeader("Access-Control-Allow-Origin", "*");

        personService = RequestHandler.getPersonService();
        String body = inputStreamToString(req.getInputStream());
        Gson gson = new Gson();
        Person p = gson.fromJson(body, Person.class);
        System.out.println(p.getFirstName());
        personService.updatePersons(p);
    }

    private static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }*/

    public void processRequest(HttpServletRequest request, HttpServletResponse response) {

        Gson gsonBuilder = new GsonBuilder().create();
        personService = RequestHandler.getPersonService();
        String userId = request.getPathInfo();
        if (userId.substring(1) == null){
            System.out.println("parameter was niet aanwezig!");
        }

        String json = gsonBuilder.toJson(personService.getPerson(userId.substring(1)));

        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        try{
            response.getWriter().write(json);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
