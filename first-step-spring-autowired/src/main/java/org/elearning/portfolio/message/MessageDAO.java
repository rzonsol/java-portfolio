package org.elearning.portfolio.message;


import java.util.List;
import javax.sql.DataSource;


public interface MessageDAO {

    void createMessage(Integer userId, String title, String content);

    List<Message> getUserMessages(Integer userId);

    void delMessage(Integer id);

    List<Message> getMessages();

}
