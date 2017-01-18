package org.elearning.portfolio.services;


import org.elearning.portfolio.message.Message;
import org.elearning.portfolio.user.Role;
import org.elearning.portfolio.user.User;
import org.elearning.portfolio.user.UserDAOCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserService{

    @Autowired
    private  UserDAOCC userDao  ;

    @Autowired
    MessageService messageService;

    public User getUser(Integer userId){return userDao.getUser(userId) ;}

    public void addUser(String login,String email, String firstName, String lastName,List<Role> roles){userDao.addUser(login, email, firstName, lastName,roles);}

    public void delUser(Integer id){
        messageService.deleteAllUserMessages(id);
        userDao.delUser(id);
    }

    public List<Message> getMessagesByUserId(Integer userId){
        return userDao.getMessagesByUserId(userId);
    }

    public void addUserRole(Integer userId, Role role) {
        userDao.addUserRole(userId, role);
    }

    public void clearUserRole(Integer userId){userDao.clearUserRole(userId);}

    public void updateUser(User user){userDao.updateUser(user);}

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public List<Role> getUserRoles(Integer userId) {
        return userDao.getUserRoles(userId);
    }
}