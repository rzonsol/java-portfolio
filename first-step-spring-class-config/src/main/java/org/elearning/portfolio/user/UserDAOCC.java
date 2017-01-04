package org.elearning.portfolio.user;


import org.elearning.portfolio.message.Message;

import java.util.List;


public interface UserDAOCC extends UserDAO{

     void addUser(String login, String email, String firstName, String lastName, List<Role> roles);

     void addUserRole(Integer userId, Role role);

}
