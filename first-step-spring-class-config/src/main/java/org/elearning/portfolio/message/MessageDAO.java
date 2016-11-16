package org.elearning.portfolio.message;


import java.util.List;


public interface MessageDAO {

    public void createMessage(Integer userId, String title, String content);

    public List<Message> getUserMessages(Integer userId);

    public void delMessage(Integer id);

    public List<Message> getMessages();

}
