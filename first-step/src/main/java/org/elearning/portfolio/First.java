package org.elearning.portfolio;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
//-----------------------------------------------------------------
//hibernate

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class First {

	private static ApplicationContext context;

	public static void main(String[] args) {


		context = new ClassPathXmlApplicationContext(
				"spring-module.xml");

		UserService ser = (UserService)context.getBean("userService");

		Role role = new Role();
		role.setRoleName("Admin");
		List<Role> roles =  Arrays.asList(role);
		ser.addUser("rzonsol","hsdg@df","piotr","rzonsol",roles);

		List<User> users= ser.getUsers();
		for(User user:users){
			System.out.println("User id: "+user.getId());
			System.out.println("User name: "+user.getFirstName());

		}


		MessageService messageService = (MessageService)context.getBean("messageService");

		messageService.createMessage(1,"title","sdhgbfjsdbhfjhsdbjdfhbsh");
		List<Message> messages = messageService.getMessages();

		for(Message mes : messages){
			System.out.println("message id: " + mes.getId());
			System.out.println("message title: "+mes.getTitle());
		}
	}

}
