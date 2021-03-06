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
import java.util.ArrayList;

import org.elearning.portfolio.services.MessageService;

/**
 * Created by rzonsol on 09.10.2016.
 */

public class UserDAOImpl implements UserDAO, UserDAOFS {

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
        Session session =null;
        User user = new User();
        try {
            if (checkUser(userId)) {
                session = this.sessionFactory.openSession();
                session.beginTransaction();
                user = (User) session.get(User.class, userId);
                session.getTransaction().commit();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally  {
            if(session!=null) {
                session.close();
            }
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
        Session session=null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session!=null) {
                session.close();
            }
            return;
        }

    }

    public void delUser(Integer id){

        if(checkUser(id)) {
            Session session=null;
            User user = new User();
            user.setId(id);
            try {
                session = this.sessionFactory.openSession();
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
            }catch (Exception ex){
                ex.printStackTrace();
                session.getTransaction().rollback();
            }finally {
                if(session!=null) {
                    session.close();
                }
                return;
            }
        }
        return;
    }

    public List<Message> getMessagesByUserId(Integer userId) {

        Session session = null;
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

    public void addUserRole(Integer userId, Role role){

        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            User user = getUser(userId);
            List<Role> roles = user.getRoles();
            if (!checkRole(user, role)) {
                roles.add(role);
            }
            user.setRoles(roles);
            session.update(user);
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

    public List<User> getUsers() {

        Session session =null;
        List<User> users=null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            users = session.createCriteria(User.class).list();
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session!=null){
                session.close();
            }
            return users;
        }

    }

    public List<Role> getUserRoles(Integer userId){

        List<Role> roles=new ArrayList<Role>();
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            if (checkUser(userId)) {
                session.beginTransaction();
                User user = (User) session.get(User.class, userId);
                roles = user.getRoles();
                session.getTransaction().commit();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if(session!=null){
                session.close();
            }
            return roles;
        }
    }
}
