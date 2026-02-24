package org.example.message.controller;

import org.example.message.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.message.service.MessageService;

import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService messageService){
        this.service = messageService;
    }
    @GetMapping
    public ResponseEntity<List<Message>> getMessages(){
        List<Message> messages = service.getMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id, @RequestParam(required = false) String caps){
        ResponseEntity<Message> response = new ResponseEntity<>(service.findMessageById(id, caps), HttpStatus.OK);
        if(!response.hasBody()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message){
        Message tempMessage = new Message(message.getContent());
        service.getRepository().addMessage(tempMessage);
        return new ResponseEntity<Message>(tempMessage, HttpStatusCode.valueOf(201));
    }

}
