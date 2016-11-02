package org.elearning.portfolio.message;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.elearning.portfolio.message.*;
//---------------------------------------------
//hibernate
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MessageDAOImpl implements MessageDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
//        String sqlCom = "INSERT INTO `MESSAGES`(USER_ID, TITLE, CONTENT) VALUES (?,?,?)";
//        jdbcTemplateObject.update( sqlCom ,userId, title, content);
        return;
    }

    public List<Message> getUserMessages(Integer userId){
//        String sqlCom = "SELECT * FROM `MESSAGES` WHERE USER_ID = ? ;";
//        List <Message> messages = jdbcTemplateObject.query(sqlCom,
//                new Object[]{userId}, new MessageMapper());
        return null;
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
        List<Message> messages = session.createCriteria(Message.class).list();
        session.close();
        return messages;
    }

}