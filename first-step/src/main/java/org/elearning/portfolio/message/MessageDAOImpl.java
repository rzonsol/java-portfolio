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

        Session session=null;
        Message message = new Message();
        message.setUserId(userId);
        message.setTitle(title);
        message.setContent(content);
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.save(message);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session!=null){
                session.close();
            }
            return;
        }
    }

    public List<Message> getUserMessages(Integer userId){

        Session session=null;
        List messages = null;

        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Message.class);
            cr.add(Restrictions.eq("userId", userId));
            messages = cr.list();
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session!=null){
                session.close();
            }
            return messages;
        }


    }

    public void delMessage(Integer id){

        if(checkMessage(id)) {
            Message message = new Message();
            message.setId(id);
            Session session=null;
            try {
                session = this.sessionFactory.openSession();
                session.beginTransaction();
                session.delete(message);
                session.getTransaction().commit();
            }catch (Exception ex){
                ex.printStackTrace();
                session.getTransaction().rollback();
            }finally {
                if(session!=null){
                    session.close();
                }
                return;
            }
        }
    }

    public List<Message> getMessages(){

        Session session =null;
        List<Message> messages=null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            messages = session.createCriteria(Message.class).list();
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null) {
                session.close();
            }
            return messages;
        }
    }

}