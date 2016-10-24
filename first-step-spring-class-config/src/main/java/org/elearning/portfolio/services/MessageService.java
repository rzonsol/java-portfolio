package org.elearning.portfolio.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;


public class MessageService{

    @Autowired
    private MessageDAO messageDao;


    public void createMessage(Integer userId, String title, String content){
        messageDao.createMessage(userId, title, content);
    }

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
}