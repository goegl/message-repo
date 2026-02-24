package org.example.message.service;

import org.example.message.model.Message;
import org.springframework.stereotype.Service;
import org.example.message.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository){
        this.repository = repository;
    }

    public MessageRepository getRepository() {
        return repository;
    }

    public List<Message> getMessages(){
        return repository.getAllMessages();
    }
    public Message findMessageById(int id, String caps){
        Message message = repository.findMessageById(id);
        if(message == null){
            return null;
        }
        if(caps != null && caps.equals("yes")){
            return new Message(message.getId(), message.getContent().toUpperCase());
        }
        return message;
    }
}
