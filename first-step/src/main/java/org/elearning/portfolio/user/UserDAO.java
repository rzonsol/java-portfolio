package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;


/**
 * Created by rzonsol on 09.10.2016.
 */
public interface UserDAO {



     /**
     * This is the method to be used to list down
     * all the records from the MESSAGES table.
     */
    public List<User> listUsers();

}
