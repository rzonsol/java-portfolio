package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.elearning.portfolio.message.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;

/**
 * Created by rzonsol on 09.10.2016.
 */

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Boolean checkUser(Integer userId){
        Session session = this.sessionFactory.openSession();
        User   user =  (User) session.get(User.class, userId);
        session.close();
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    public User  getUser(Integer userId){

        User user = new User();
        if(checkUser(userId)) {
            Session session = this.sessionFactory.openSession();
            user = (User) session.get(User.class, userId);
            session.close();
            return user;
        }else {
            return user;
        }
    }

    public void addUser(String login,String email, String firstName, String lastName){

        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Session session = this.sessionFactory.openSession();
        session.save(user);
        session.close();
        return;
    }

    public void delUser(Integer id){
        if(checkUser(id)) {
            User user = new User();
            user.setId(id);
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }
        return;
    }

    public List<Message> getMessagesByUserId(Integer userId) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Message.class);
        cr.add(Restrictions.eq("userId", userId));
        List messages = cr.list();
        tx.commit();
        session.close();
        return messages;
    }

    public void addUserRole(Integer userId, Integer roleId){
        Session session = this.sessionFactory.openSession();
        Query query = session.createSQLQuery("INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (:userId,:roleId)");
        query.setParameter("userId", userId);
        query.setParameter("roleId", roleId);
        query.executeUpdate();
        session.close();
        return;
    }

        public List<User> getUsers() {
            Session session = this.sessionFactory.openSession();
            List<User> users = session.createCriteria(User.class).list();
            session.close();
        return users;
    }

    public List<Role> getUserRoles(Integer userId){
        Session session = this.sessionFactory.openSession();
        Query query = session.createSQLQuery("SELECT DISTINCT USER_ROLES.ROLE_ID, ROLES.NAME FROM ROLES LEFT JOIN USER_ROLES ON ROLES.ID=USER_ROLES.ROLE_ID WHERE USER_ROLES.USER_ID = :userId");
        query.setParameter("userId", userId);
        List<Role> roles = query.list();
        session.close();
        return roles;
    }
}
