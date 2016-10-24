package org.elearning.portfolio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import java.util.List;


public class First {

	private static ApplicationContext context;

	public static void main(String[] args) {


		context = new ClassPathXmlApplicationContext(
				"spring-module.xml");




		UserService ser = (UserService)context.getBean("userService");

		MessageService messag = (MessageService)context.getBean("messageService");



		User user = ser.getUser(1); //list of all users

		System.out.println(user.getFullName());
		System.out.println(user.getLastName());
//		System.out.println("list of users");
//		for (User e : users){
//			System.out.println(e.getUserFullName(e));
//
//		}

//		messag.createMessage(2,"test","test");
//		messag.createMessage(2,"test2","test2");
//		messag.createMessage(2,"test3","test3");
//
//		List<Message> messages = messag.getMessages(); //list of all messages
//
//		System.out.println("list of messages");
//		for (Message e : messages){
//			System.out.print("id " + e.getId());
//			System.out.print(", user_id " + e.getUserId());
//			System.out.print(", title " + e.getUserId());
//			System.out.println(", content " + e.getContent());
//		}

	}

}
