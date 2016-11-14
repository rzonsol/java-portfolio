package org.elearning.portfolio;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import java.util.List;


public class First {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigBean.class);
		ctx.refresh();

		UserService ser = (UserService)ctx.getBean("userService");
		MessageService messag = (MessageService)ctx.getBean("messageService");

		List<User> users = ser.getUsers(); //list of all users
		System.out.println("list of users");
		for (User e : users){
			System.out.print("id " + e.getId());
			System.out.print(", login " + e.getLogin());
			System.out.print(", email " + e.getEmail());
			System.out.print(", firstName " + e.getFirstName());
			System.out.println(", lastName " + e.getLastName());
		}

		messag.createMessage(2,"test","test");
		messag.createMessage(2,"test2","test2");
		messag.createMessage(2,"test3","test3");

		List<Message> messages = messag.getMessages(); //list of all messages
		System.out.println("list of messages");
		for (Message e : messages){
			System.out.print("id " + e.getId());
			System.out.print(", user_id " + e.getUserId());
			System.out.print(", title " + e.getUserId());
			System.out.println(", content " + e.getContent());
		}
	}
}



