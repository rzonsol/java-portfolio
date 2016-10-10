package org.elearning.portfolio;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by rzonsol on 09.10.2016.
 */
public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<User> listStudents() {
        String H2 = "SELECT * FROM USERS1 ;";
        List <User> users = jdbcTemplateObject.query(H2,
                new StudentMapper());
        return users;
    }





}
