package org.elearning.portfolio.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;


public class UserService{

    @Autowired
    private  UserDAO userDao  ;

    public UserService(){
        this.userDao = userDao;
    }

    public void setUser(UserDAO userDao){this.userDao = userDao;}

    public User getUser(Integer userId){return userDao.getUser(userId) ;}

    public void addUser(String login,String email, String firstName, String lastName,List<Role> roles){userDao.addUser(login, email, firstName, lastName,roles);}

    public void delUser(Integer id){
        userDao.delUser(id);
    }

    public List<Message> getMessagesByUserId(Integer userId){
        return userDao.getMessagesByUserId(userId);
    }

    public void addUserRole(Integer userId, Role role) {
        userDao.addUserRole(userId, role);
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public List<Role> getUserRoles(Integer userId) {
        return userDao.getUserRoles(userId);
    }
}