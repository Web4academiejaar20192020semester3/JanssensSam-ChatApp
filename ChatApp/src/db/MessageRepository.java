package db;

import domain.Message;

import java.util.ArrayList;

public interface MessageRepository {
    public abstract ArrayList<Message> getAll();
    public abstract void addMessage(Message message);
}
