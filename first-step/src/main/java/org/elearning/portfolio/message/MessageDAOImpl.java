package org.elearning.portfolio.message;


import java.util.List;
import org.elearning.portfolio.message.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class MessageDAOImpl implements MessageDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

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
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();
        session.close();
        return;
    }

    public List<Message> getUserMessages(Integer userId){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Message.class);
        cr.add(Restrictions.eq("userId", userId));
        List messages =  cr.list();
        session.getTransaction().commit();
        session.close();
        return messages;
    }

    public void delMessage(Integer id){
        if(checkMessage(id)) {
            Message message = new Message();
            message.setId(id);
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.delete(message);
            session.getTransaction().commit();
            session.close();
        }
        return;
    }

    public List<Message> getMessages(){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Message> messages = session.createCriteria(Message.class).list();
        session.getTransaction().commit();
        session.close();
        return messages;
    }

}