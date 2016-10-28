package org.elearning.portfolio.message;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MessageMapper implements RowMapper<Message> {

    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt("ID"));
        message.setUserId(rs.getInt("USER_ID"));
        message.setTitle(rs.getString("TITLE"));
        message.setContent(rs.getString("CONTENT"));
        return message;
    }
}