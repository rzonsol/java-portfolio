package org.elearning.portfolio.message;


import java.util.List;
import javax.sql.DataSource;

public interface MessageDAO {
    /**
     * This is the method to be used to create
     * a record in the MESSAGES table.
     */
    public void createMessage(Integer userId, String title, String content);
    /**
     * This is the method to be used to
     * get all message of user_id
     */
    public List<Message> getUserMessages(Integer userId);

    /**
     * This is the method to be used to
     * remove message of id
     */

    public void delMessage(Integer id);

    /**
     * This is the method to be to count all messages
     * of user_id
     */

    public Integer countMessages(Integer userId);

    /**
     * This is the method to be used to list down
     * all the records from the messages table.
     */
    public List<Message> getMessages();

}
