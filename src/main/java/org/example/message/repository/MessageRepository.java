package org.example.message.repository;

import org.example.message.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private final List<Message> messages = new ArrayList<>();
    private int messageId = 1;

    public MessageRepository(){
        populateMessages();
    }
    public Message addMessage(Message message){
        message.setId(messageId);
        messages.add(message);
        messageId++;
        return message;
    }

    private void populateMessages(){
        while(messageId <= 3){
            messages.add(new Message(messageId, "Velkommen til " + messageId + ". semester"));
            messageId++;
        }
    }


    public List<Message> getAllMessages(){
        return messages;
    }

    public Message findMessageById(int id){
        for(Message message : messages){
            if(message.getId() == id){
                return message;
            }
        }
        return null;
    }

}
