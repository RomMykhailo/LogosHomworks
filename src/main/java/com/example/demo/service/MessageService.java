package com.example.demo.service;

import com.example.demo.entity.MessageEntity;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage (MessageEntity messageEntity){
        messageEntity.setMessage(messageEntity.getMessage().toUpperCase());
        MessageEntity messageEntity2;
        messageRepository.save(messageEntity);
    }

    public List<MessageEntity> getAllMessage (){
        List<MessageEntity> ms = messageRepository.findAll();
        return ms;
    }

    public MessageEntity getMessageById (Long i){
        return messageRepository.getOne(i);
    }

}
