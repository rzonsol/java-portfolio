package org.elearning.portfolio.user;


import org.elearning.portfolio.message.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO, UserDAOCC {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
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
            Session session = getSession();
            user = (User) session.get(User.class, userId);
            return user;
        }else {
            return user;
        }
    }

    public void addUser(String login,String email, String firstName, String lastName,List<Role> roles){

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setEmail(email);
        user.setRoles(roles);
        Session session = getSession();
        session.save(user);
        return;
    }

    public void delUser(Integer id){

        if(checkUser(id)) {
            User user = new User();
            user.setId(id);
            Session session = getSession();
            session.delete(user);
        }
        return;
    }

    public List<Message> getMessagesByUserId(Integer userId) {

        Session session = getSession();
        Criteria cr = session.createCriteria(Message.class);
        cr.add(Restrictions.eq("userId", userId));
        List messages =  cr.list();
        return messages;
    }

    public void addUserRole(Integer userId, Role role){

        Session session = getSession();
        User user = getUser(userId);
        List<Role> roles = user.getRoles();
        if(!checkRole(user,role)){
            roles.add(role);
        }
        user.setRoles(roles);
        session.update(user);
        return;
    }

    public void clearUserRole(Integer userId){
        Session session = getSession();
        User user = getUser(userId);
        user.setRoles(null);
        session.update(user);
        return;
    }

    public void updateUser(User user){
        Session session = getSession();

        if(checkUser(user.getId())){
            session.update(user);
        }
       return;
    }

    public List<User> getUsers() {

        Session session = getSession();
        session.clear();
        Criteria criteria = session.createCriteria(User.class);
        return (List<User>) criteria.list() ;
    }

    public List<Role> getUserRoles(Integer userId){

        List<Role> roles=new ArrayList<Role>();
        Session session = getSession();
        if(checkUser(userId)) {
            User user =   (User)session.get(User.class, userId);
            roles = user.getRoles();
            return roles;
        }
        return roles;

    }
}
