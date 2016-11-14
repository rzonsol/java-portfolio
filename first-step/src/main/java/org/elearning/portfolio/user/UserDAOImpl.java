package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;

import org.hibernate.mapping.Array;
import org.springframework.jdbc.core.JdbcTemplate;
import org.elearning.portfolio.message.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;
import java.util.ArrayList;

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

    private Boolean checkRole(User user, Role role){
        List<Role> roles = user.getRoles();
        for(Role r : roles){
            if(r.getRoleName().equals(role.getRoleName())){
                return true;
            }
        }
        return false;
    }

    public User  getUser(Integer userId){
        User user = new User();
        if(checkUser(userId)) {
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            user = (User) session.get(User.class, userId);
            session.getTransaction().commit();
            session.close();
            return user;
        }else {
            return user;
        }
    }

    public void addRole(Role role){
        Session session = this.sessionFactory.openSession();
        session.save(role);
        session.close();
        return;
    }

    public void addUser(String login,String email, String firstName, String lastName, List<Role> roles){

        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoles(roles);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
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

    public void addUserRole(Integer userId, Role role){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        User user = getUser(userId);
        List<Role> roles = user.getRoles();
        if(!checkRole(user,role)){
            roles.add(role);
        }
        user.setRoles(roles);
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return;
    }

    public List<User> getUsers() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        session.close();
    return users;
    }

    public List<Role> getUserRoles(Integer userId){
        List<Role> roles=new ArrayList<Role>();
        Session session = this.sessionFactory.openSession();
        if(checkUser(userId)) {
            session.beginTransaction();
            User user =   (User)session.get(User.class, userId);
            roles = user.getRoles();
            session.getTransaction().commit();
            session.close();
            return roles;
        }
        return roles;
    }
}
// TODO do zrobienia metoda getMessagesByUserId