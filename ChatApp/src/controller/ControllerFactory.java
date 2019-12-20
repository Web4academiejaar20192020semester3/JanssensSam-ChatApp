package controller;

import domain.MessageService;
import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService personModel, MessageService messageModel) {
        return createHandler(key, personModel, messageModel);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService personModel, MessageService messageModel) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setPersonModel(personModel);
	    	handler.setMessageModel(messageModel);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
