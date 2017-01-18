package org.elearning.portfolio.message;

/**
 * Created by rzonsol on 18.01.2017.
 */
public interface MessageDAOCC extends MessageDAO {

    void deleteAllUserMessages(Integer userId);
}
