package org.elearning.portfolio.message;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MessageDAOImpl implements MessageDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void createMessage(Integer userId, String title, String content){
        String sqlCom = "INSERT INTO `MESSAGES`(USER_ID, TITLE, CONTENT) VALUES (?,?,?)";
        jdbcTemplateObject.update( sqlCom ,userId, title, content);
        return;
    }

    public List<Message> userMessages(Integer userId){
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

    public Integer countMessages(Integer userId){

        String sqlCom = "SELECT COUNT(`USER_ID`) FROM MESSAGES WHERE `USER_ID`=?";
        Integer numberMesseges = jdbcTemplateObject.queryForObject(sqlCom,
                new Object[] {userId}, Integer.class);
        return (numberMesseges != null ? numberMesseges.intValue() : 0);
    }


    public List<Message> listMessage(){
        String sqlCom = "SELECT * FROM MESSAGES ;";
        List <Message> messages = jdbcTemplateObject.query(sqlCom,
                new MessageMapper());
        return messages;
    }

}