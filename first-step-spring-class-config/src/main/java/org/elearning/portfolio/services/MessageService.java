package org.elearning.portfolio.services;

import org.elearning.portfolio.message.Message;
import org.elearning.portfolio.message.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
}