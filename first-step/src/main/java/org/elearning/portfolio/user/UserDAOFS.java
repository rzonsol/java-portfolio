package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;
import org.elearning.portfolio.message.*;


/**
 * Created by rzonsol on 09.10.2016.
 */
public interface UserDAOFS extends UserDAO{


    void addUser(String login,String email, String firstName, String lastName, List<Role> roles);

    void addRole(Role role);

    void delUser(Integer id);

    void addUserRole(Integer userId, Role role);

    List<User> getUsers();

    List<Role> getUserRoles(Integer userId);
}
