package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MessageService;
import domain.PersonService;
import domain.Person;
import domain.Role;

import java.io.IOException;

public abstract class RequestHandler {
	
	private static PersonService personService;
	private MessageService messageService;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void setPersonModel (PersonService personService) {
		this.personService = personService;
	}

	public static PersonService getPersonService() {
		return personService;
	}
	
	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

	public void setMessageModel (MessageService messageService){ this.messageService = messageService; }

	public MessageService getMessageService () { return messageService; }

}
