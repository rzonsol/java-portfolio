package org.elearning.portfolio.message;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public class MessageDAOImpl implements MessageDAO, MessageDAOCC {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    private Boolean checkMessage(Integer messageId){

        Session session = this.sessionFactory.openSession();
        Message   message =  (Message) session.get(Message.class, messageId);
        session.close();
        if(message!=null){
            return true;
        }else{
            return false;
        }
    }

    public void createMessage(Integer userId, String title, String content){

        Message message = new Message();
        message.setUserId(userId);
        message.setTitle(title);
        message.setContent(content);
        Session session = getSession();
        session.save(message);
        return;
    }

    public List<Message> getUserMessages(Integer userId){

            Session session = getSession();
            Criteria cr = session.createCriteria(Message.class);
            cr.add(Restrictions.eq("userId", userId));
            List messages =  cr.list();
            return messages;
    }

    public void delMessage(Integer id){

        if(checkMessage(id)) {
            Message message = new Message();
            message.setId(id);
            Session session = getSession();
            session.clear();
            session.delete(message);
        }
        return;
    }

    public void deleteAllUserMessages(Integer userId){
        List<Message> messageList = getUserMessages(userId);
        for(Message message:messageList){
            delMessage(message.getId());
        }
    }
    public List<Message> getMessages(){

        Session session = getSession();
        List<Message> messages = session.createCriteria(Message.class).list();
        return messages;
    }

}