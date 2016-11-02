package org.elearning.portfolio.user;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.elearning.portfolio.message.*;
//---------------------------------------------
//hibernate
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by rzonsol on 09.10.2016.
 */

public class UserDAOImpl implements UserDAO {
//    private DataSource dataSource;
//    private JdbcTemplate jdbcTemplateObject;

    //---------
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private Boolean checkUser(Integer userId){
        Session session = this.sessionFactory.openSession();
        User   user =  (User) session.get(User.class, userId);
        session.close();
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    public User  getUser(Integer userId){
        User user = new User();
        if(checkUser(userId)) {
            Session session = this.sessionFactory.openSession();
            user = (User) session.get(User.class, userId);
            session.close();
            return user;
        }else {
            return user;
        }
    }

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//    }

    public void addUser(String login,String email, String firstName, String lastName){
//        String sqlCom = "INSERT INTO `USER`(LOGIN, EMAIL, FIRST_NAME, LAST_NAME) VALUES (?,?,?,?)";
//        jdbcTemplateObject.update(sqlCom, login ,email, firstName, lastName);
        return;
    }

    public void delUser(Integer id){
//        String sqlCom = "DELETE FROM `USER` WHERE ID = ?";
//        jdbcTemplateObject.update(sqlCom,id);
    }

    public List<Message> getMessagesByUserId(Integer userId) {
//        String sqlCom = "SELECT * FROM `MESSAGES` WHERE USER_ID = ? ;";
//        List<Message> messages = jdbcTemplateObject.query(sqlCom,
//                new Object[]{userId}, new MessageMapper());
        return null;
    }

    public void addUserRole(Integer userId, Integer roleId){
//        String sqlCom ="INSERT INTO `USER_ROLES` (USER_ID, ROLE_ID) VALUES (?,?)";
//        jdbcTemplateObject.update(sqlCom, userId ,roleId);
        return;
    }


        public List<User> getUsers() {
            Session session = this.sessionFactory.openSession();
            List<User> users = session.createCriteria(User.class).list();
            session.close();
        return users;
    }


    public List<Role> getUserRoles(Integer userId){
//        String sqlCom = "SELECT DISTINCT USER_ROLES.ROLE_ID, ROLES.NAME FROM ROLES LEFT JOIN USER_ROLES ON ROLES.ID=USER_ROLES.ROLE_ID WHERE USER_ROLES.USER_ID = ?;";
//        List<Role> roles = jdbcTemplateObject.query(sqlCom,
//                new Object[]{userId}, new RoleMapper());
        return null;
    }



}
