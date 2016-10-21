package org.elearning.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import org.elearning.portfolio.services.CreateDataSourceForJdbcTemplate;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.services.UserService;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.MessageService;


@Configuration
public class AppConfigBean{

    @Bean
    public CreateDataSourceForJdbcTemplate createDataSourceForJdbcTemplate(){
        return new CreateDataSourceForJdbcTemplate();
    }
    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }
    @Bean
    public UserService userService(){
        return new UserService(userDAO());
    }
    @Bean
    public MessageDAO messageDAO(){
        return new MessageDAOImpl();
    }
    @Bean
    public MessageService messageService(){
        return new MessageService(messageDAO());
    }


}