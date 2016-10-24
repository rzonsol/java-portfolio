package org.elearning.portfolio.user;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role> {

    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setRoleId(rs.getInt("ROLE_ID"));
        role.setRoleName(rs.getString("NAME"));
        return role;
    }
}