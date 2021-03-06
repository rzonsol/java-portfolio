package org.elearning.portfolio.services;


import java.util.List;

import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;


public class UserService{

    private  UserDAOFS user  ;

    public UserService(UserDAOFS user){
        this.user = user;
    }

    public void setUser(UserDAOFS user){this.user = user;}

    public User getUser(Integer userId){return user.getUser(userId) ;}

    public void addUser(String login,String email, String firstName, String lastName, List<Role> roles){
        user.addUser(login, email, firstName, lastName, roles);
    }

    public void delUser(Integer id){
        user.delUser(id);
    }

    public List<Message> getMessagesByUserId(Integer userId){
        return user.getMessagesByUserId(userId);
    }

    public void addUserRole(Integer userId, Role role) {
        user.addUserRole(userId, role);
    }

    public List<User> getUsers(){
        return user.getUsers();
    }

    public List<Role> getUserRoles(Integer userId) {
        return user.getUserRoles(userId);
    }

    public void addRole(Role role){user.addRole(role);return;}
}