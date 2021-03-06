package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;
import javax.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.elearning.portfolio.message.*;




/**
 * Created by rzonsol on 09.10.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO, UserDAOA {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public User  getUser(Integer userId){
        String sqlCom = "SELECT * FROM `USER` WHERE ID = ? ";
        List <User> users = jdbcTemplateObject.query(sqlCom,
                new Object[]{userId}, new UserMapper());
        return users.get(0);
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void addUser(String login,String email, String firstName, String lastName){
        String sqlCom = "INSERT INTO `USER`(LOGIN, EMAIL, FIRST_NAME, LAST_NAME) VALUES (?,?,?,?)";
        jdbcTemplateObject.update(sqlCom, login ,email, firstName, lastName);
        return;
    }

    public void delUser(Integer id){
        String sqlCom = "DELETE FROM `USER` WHERE ID = ?";
        jdbcTemplateObject.update(sqlCom,id);
    }

    public List<Message> getMessagesByUserId(Integer userId) {
        String sqlCom = "SELECT * FROM `MESSAGES` WHERE USER_ID = ? ;";
        List<Message> messages = jdbcTemplateObject.query(sqlCom,
                new Object[]{userId}, new MessageMapper());
        return messages;
    }

    public void addUserRole(Integer userId, Integer roleId){
        String sqlCom ="INSERT INTO `USER_ROLES` (USER_ID, ROLE_ID) VALUES (?,?)";
        jdbcTemplateObject.update(sqlCom, userId ,roleId);
        return;
    }

    public List<User> getUsers() {
        String sqlCon = "SELECT * FROM USER ;";
        List <User> users = jdbcTemplateObject.query(sqlCon,
                new UserMapper());
        return users;
    }

    public List<Role> getUserRoles(Integer userId){
        String sqlCom = "SELECT DISTINCT USER_ROLES.ROLE_ID, ROLES.NAME FROM ROLES LEFT JOIN USER_ROLES ON ROLES.ID=USER_ROLES.ROLE_ID WHERE USER_ROLES.USER_ID = ?;";
        List<Role> roles = jdbcTemplateObject.query(sqlCom,
                new Object[]{userId}, new RoleMapper());
        return roles;
    }
}
