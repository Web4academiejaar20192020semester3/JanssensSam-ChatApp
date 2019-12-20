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


@WebServlet("/GetUsers")
public class GetUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PersonService personService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        String userId = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setGender(gender);
        p.setAge(Integer.parseInt(age));
        personService.updatePersons(userId, p);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) {

        Gson gsonBuilder = new GsonBuilder().create();
        personService = RequestHandler.getPersonService();

        String json = gsonBuilder.toJson(personService.getPersons());

        response.setContentType("application/json");
        // setting the CORS request, CrossOriginResourceSharing
        // so that this url/response is accessible in another domain (angular application for example)
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            response.getWriter().write(json);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
