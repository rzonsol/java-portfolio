package org.elearning.portfolio.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.message.Message;


public class MessageService{

    @Autowired
    private MessageDAO messageDao;


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
//        Message message1 = new Message();
//        Message message2 = new Message();
//        message1.setTitle("");
//        message2.setTitle("te");
//        List<Message> messagess = new ArrayList<Message>();
//
//        messagess.add(message1);
//        messagess.add(message2);
//        messagesWithString=messagess;
        return messagesWithString;
    }
}