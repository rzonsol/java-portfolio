package org.elearning.portfolio.user;


import org.elearning.portfolio.message.Message;

import java.util.List;


public interface UserDAO {

     User getUser(Integer id);

     void addUser(String login, String email, String firstName, String lastName, List<Role> roles);

     void delUser(Integer id);

     void addUserRole(Integer userId, Role role);

     List<Message> getMessagesByUserId(Integer userId);

     List<User> getUsers();
 
     List<Role> getUserRoles(Integer userId);
}
