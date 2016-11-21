package org.elearning.portfolio;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class First {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigBean.class);
		ctx.refresh();

		UserService ser = (UserService)ctx.getBean("userService");




		Role role = new Role();
		role.setRoleName("Admin");
		List<Role> roles =  Arrays.asList(role);
		ser.addUser("rzonsol","hsdg@df","piotr","rzonsol",roles);

		List<User> users= ser.getUsers();
		for(User user:users){
			System.out.println("User id: "+user.getId());
			System.out.println("User name: "+user.getFirstName());

		}


		MessageService messageService = (MessageService)ctx.getBean("messageService");

		messageService.createMessage(1,"title","sdhgbfjsdbhfjhsdbjdfhbsh");
		List<Message> messages = messageService.getMessages();

		for(Message mes : messages){
			System.out.println("message id: " + mes.getId());
			System.out.println("message title: "+mes.getTitle());
		}


	}
}



