package org.elearning.portfolio.user;


import org.elearning.portfolio.message.Message;

import java.util.List;


public interface UserDAO  {

     User getUser(Integer id);

     void delUser(Integer id);

     List<Message> getMessagesByUserId(Integer userId);

     List<User> getUsers();
 
     List<Role> getUserRoles(Integer userId);
}
