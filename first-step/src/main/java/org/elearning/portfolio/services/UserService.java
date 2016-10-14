package org.elearning.portfolio.services;


import java.util.List;
import javax.sql.DataSource;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;


public class UserService{

    private  UserDAOImpl user  ;

    public void setUser(UserDAOImpl user){this.user = user;}

    public UserDAOImpl getUser(){return user ;}


    public void addUser(String login,String email, String firstName, String lastName){
        user.addUser(login, email, firstName, lastName);
    }

    public void delUser(Integer id){
        user.delUser(id);
    }

    public List<Message> getMessagesByUserId(Integer userId){
        return user.getMessagesByUserId(userId);
    }

    public void addUserRole(Integer userId, Integer roleId) {
        user.addUserRole(userId, roleId);
    }

    public List<User> getUsers(){
        return user.getUsers();
    }

    public List<Role> getUserRoles(Integer userId) {
        return user.getUserRoles(userId);
    }
}