package org.elearning.portfolio;


import java.util.List;
import javax.sql.DataSource;


/**
 * Created by rzonsol on 09.10.2016.
 */
public interface UserDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
     /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    public List<User> listUsers();

}
