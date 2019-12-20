package domain;

import java.util.ArrayList;
import java.util.List;

import db.MessageRepository;
import db.MessageRepositoryStub;
import db.PersonRepository;
import db.PersonRepositoryStub;

public class MessageService {
    private MessageRepository messageRepository = new MessageRepositoryStub();

    public ArrayList<Message> getAll() {
        return this.messageRepository.getAll();
    }
    public void addMessage(Message message) {
        this.messageRepository.addMessage(message);
    }
}
