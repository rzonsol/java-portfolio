package org.elearning.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

import org.elearning.portfolio.user.*;
import org.elearning.portfolio.services.UserService;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.MessageService;


@Configuration
@ComponentScan(basePackages = "org.elearning.portfolio")
@Import(HibernateConfiguration.class)
public class AppConfigBean{

//    private static final String driverClassName = "org.h2.Driver";
//    private static final String url = "jdbc:h2:file:./target/portfolio-db";
//    private static final String dbUsername = "sa";
//    private static final String dbPassword = "sa";
//
//    @Bean
//    public DataSource getDataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(dbUsername);
//        dataSource.setPassword(dbPassword);
//        return dataSource;
//    }

    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }
    @Bean
    public UserService userService(){
        return new UserService();
    }
    @Bean
    public MessageDAO messageDAO(){
        return new MessageDAOImpl();
    }
    @Bean
    public MessageService messageService(){
        return new MessageService();
    }


}