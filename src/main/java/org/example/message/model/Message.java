package org.example.message.model;

public class Message {
    private int id;
    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }
    public Message(String content){
        this.content = content;
    }

    public Message(){};

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
