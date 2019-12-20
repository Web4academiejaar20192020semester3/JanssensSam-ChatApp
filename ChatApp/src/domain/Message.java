package domain;

public class Message implements Comparable {
    private String sender;
    private String receiver;
    private String content;
    private int index;

    public Message(String sender, String receiver, String content, int index) {
        setSender(sender);
        setReceiver(receiver);
        setContent(content);
        setIndex(index);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Object m) {
        int compareIndex=((Message) m).getIndex();
        return this.index-compareIndex;
    }
}
