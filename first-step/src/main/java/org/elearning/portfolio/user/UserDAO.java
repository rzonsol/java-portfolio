package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;
import org.elearning.portfolio.message.*;


/**
 * Created by rzonsol on 09.10.2016.
 */
public interface UserDAO {
    /**
     * This is the method to be used to get
     * data of user from USER table.
     */
    public List <User> getUser(Integer id);
    /**
     * This is the method to be used to create
     * new user in the USER table.
     */
    public void addUser(String login,String email, String firstName, String lastName);
    /**
     * This is the method to be used to
     * remove User of id
     */

    public void delUser(Integer id);

    /**
     * This is the method to be used to
     * add role to User
     */

    public void addUserRole(Integer userId, Integer roleId);

    /**
     * This is the method to be used to
     * get all message of user_id
     */
    public List<Message> getMessagesByUserId(Integer userId);

     /**
     * This is the method to be used to list down
     * all the records from the MESSAGES table.
     */
    public List<User> getUsers();
    /**
     * This is the method to be used to list down
     * all the roles of user.
     */
    public List<Role> getUserRoles(Integer userId);
}
