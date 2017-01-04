package org.elearning.portfolio.user;

import java.util.List;
import javax.sql.DataSource;
import org.elearning.portfolio.message.*;


/**
 * Created by rzonsol on 09.10.2016.
 */
public interface UserDAOA extends UserDAO{

    void addUser(String login, String email, String firstName, String lastName);

    public void addUserRole(Integer userId, Integer roleId);

}
