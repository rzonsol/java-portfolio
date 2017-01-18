package org.elearning.portfolio;

import org.elearning.portfolio.message.MessageDAO;
import org.elearning.portfolio.message.MessageDAOCC;
import org.elearning.portfolio.message.MessageDAOImpl;
import org.elearning.portfolio.services.MessageService;
import org.elearning.portfolio.services.UserService;
import org.elearning.portfolio.user.UserDAO;
import org.elearning.portfolio.user.UserDAOCC;
import org.elearning.portfolio.user.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = "org.elearning.portfolio")
@Import(HibernateConfiguration.class)
public class AppConfigBean{

    @Bean
    public UserDAOCC userDAO(){
        return new UserDAOImpl();
    }
    @Bean
    public UserService userService(){
        return new UserService();
    }
    @Bean
    public MessageDAOCC messageDAO(){
        return new MessageDAOImpl();
    }
    @Bean
    public MessageService messageService(){
        return new MessageService();
    }


}