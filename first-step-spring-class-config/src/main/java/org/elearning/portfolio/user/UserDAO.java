package org.elearning.portfolio.user;


import org.elearning.portfolio.message.Message;

import java.util.List;


public interface UserDAO {

    public User getUser(Integer id);

    public void addUser(String login, String email, String firstName, String lastName,List<Role> roles);

    public void delUser(Integer id);

    public void addUserRole(Integer userId, Role role);

    public List<Message> getMessagesByUserId(Integer userId);

    public List<User> getUsers();
 
    public List<Role> getUserRoles(Integer userId);
}
