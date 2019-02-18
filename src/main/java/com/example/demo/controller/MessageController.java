package com.example.demo.controller;

import com.example.demo.entity.MessageEntity;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity createMessage (
            @RequestBody MessageEntity messageEntity
    ){
        messageService.saveMessage(messageEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/messages")
    public ResponseEntity readMessages(){
        return ResponseEntity.ok(messageService.getAllMessage());
    }

    @GetMapping("/message/{messageIndex}")
    public ResponseEntity<?> showMessageByIndex (
            @PathVariable("messageIndex") Long messIndex
    ){
        if ((messageService.getAllMessage().size() - 1 < messIndex) || (messIndex < 0) ){
            return new ResponseEntity<>("Incorrect index", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(messageService.getMessageById(messIndex),HttpStatus.OK);
    }

    @PutMapping("/message/")
    public ResponseEntity<?> updateMessageById (
                       @RequestParam (required = false, name = "message") String mess
    ){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(mess);
        messageService.saveMessage(messageEntity);
        return new ResponseEntity<>(messageService.getAllMessage(), HttpStatus.OK);
    }
}
