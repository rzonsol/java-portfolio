package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;
import org.elearning.portfolio.message.*;


/**
 * Created by rzonsol on 09.10.2016.
 */
public interface UserDAO {

    public User getUser(Integer id);

    public void addUser(String login, String email, String firstName, String lastName);


    public void delUser(Integer id);


    public void addUserRole(Integer userId, Integer roleId);

    public List<Message> getMessagesByUserId(Integer userId);


    public List<User> getUsers();
 
    public List<Role> getUserRoles(Integer userId);
}
