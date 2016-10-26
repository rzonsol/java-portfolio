package org.elearning.portfolio.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;


public class MessageService{

    @Autowired
    private MessageDAO messageDao;

    public MessageService(){
        this.messageDao= messageDao;
    }

    public void createMessage(Integer userId, String title, String content){messageDao.createMessage(userId, title, content);}

    public List <Message>  getUserMessages(Integer userId){
        return messageDao.getUserMessages(userId);
    }

    public void delMessage(Integer id){
        messageDao.delMessage(id);
    }

    public Integer countMessages(Integer userId){
        return messageDao.getUserMessages(userId).size();
    }

    public List<Message> getMessages(){
        return messageDao.getMessages();
    }

    public List<Message> getMessagesWithStringInTitle(String lookFor){
        List<Message> messages = messageDao.getMessages();
        List<Message> messagesWithString = new ArrayList<Message>();
        for (Message e : messages){
            String title = e.getTitle();
            if(title.toLowerCase().contains(lookFor.toLowerCase())){
                messagesWithString.add(e);
            }
        }
        return messagesWithString;
    }
}