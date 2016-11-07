package org.elearning.portfolio.services;

import java.util.List;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;


public class MessageService{
    private MessageDAO message;

    public MessageService(MessageDAO message){
        this.message= message;
    }

    public void createMessage(Integer userId, String title, String content){
        message.createMessage(userId, title, content);
    }

    public List <Message>  getUserMessages(Integer userId){
        return message.getUserMessages(userId);
    }

    public void delMessage(Integer id){
        message.delMessage(id);
    }

    public Integer countMessages(Integer userId){
        return message.getUserMessages(userId).size();
    }

    public List<Message> getMessages(){
        return message.getMessages();
    }
}