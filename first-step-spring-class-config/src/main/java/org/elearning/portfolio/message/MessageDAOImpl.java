package org.elearning.portfolio.message;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.elearning.portfolio.CreateDataSourceForJdbcTemplate;



public class MessageDAOImpl implements MessageDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(CreateDataSourceForJdbcTemplate dataSource) {
        this.dataSource = dataSource.getDataSource();
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    public void createMessage(Integer userId, String title, String content){
        String sqlCom = "INSERT INTO `MESSAGES`(USER_ID, TITLE, CONTENT) VALUES (?,?,?)";
        jdbcTemplateObject.update( sqlCom ,userId, title, content);
        return;
    }

    public List<Message> getUserMessages(Integer userId){
        String sqlCom = "SELECT * FROM `MESSAGES` WHERE USER_ID = ? ;";
        List <Message> messages = jdbcTemplateObject.query(sqlCom,
                new Object[]{userId}, new MessageMapper());
        return messages;
    }

    public void delMessage(Integer id){
        String sqlCom = "DELETE FROM `MESSAGES` WHERE ID = ?";
        jdbcTemplateObject.update(sqlCom,id);
        return;
    }

    public List<Message> getMessages(){
        String sqlCom = "SELECT * FROM MESSAGES ;";
        List <Message> messages = jdbcTemplateObject.query(sqlCom,
                new MessageMapper());
        return messages;
    }

}