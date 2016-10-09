package org.elearning.portfolio;

/**
 * Created by rzonsol on 09.10.2016.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("ID"));
        student.setEmail(rs.getString("EMAIL"));
        student.setLogin(rs.getString("LOGIN"));
        return student;
    }
}