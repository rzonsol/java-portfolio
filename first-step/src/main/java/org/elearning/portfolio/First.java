package org.elearning.portfolio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;

import java.util.List;


public class First {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext(
				"spring-module.xml");

		UserDAOImpl userDAOImpl =
				(UserDAOImpl)context.getBean("userDAOImpl");


		System.out.println("------Listing Multiple Records--------" );
		List<User> users = userDAOImpl.listUsers();
		for (User record : users) {
			System.out.print("ID : " + record.getId() );
			System.out.print(", LOGIN : " + record.getLogin() );
			System.out.print(", FIRST_NAME : " + record.getFirstName());
			System.out.print(", LAST_NAME : " + record.getLastName());
			System.out.print(", LOGIN : " + record.getLogin() );
			System.out.println(", EMAIL : " + record.getEmail());
		}



		MessageDAOImpl messageDAOImple =
				(MessageDAOImpl)context.getBean("messageDAOImpl");

		messageDAOImple.createMessage(1,"test","test");
		messageDAOImple.createMessage(1,"test2","test2");
		messageDAOImple.createMessage(1,"test3","test3");
		messageDAOImple.createMessage(1,"test4","test4");

 		messageDAOImple.createMessage(2,"test","test");
		messageDAOImple.createMessage(2,"test2","test2");
		messageDAOImple.createMessage(2,"test3","test3");

 		messageDAOImple.createMessage(3,"test","test");
		messageDAOImple.createMessage(3,"test2","test2");
		messageDAOImple.createMessage(3,"test3","test3");


		List<Message> messages = messageDAOImple.listMessage(); //list of all messages

		System.out.println("list of messages");
		for (Message e : messages){
			System.out.print("id " + e.getId());
			System.out.print(", user_id " + e.getUserId());
			System.out.print(", title " + e.getUserId());
			System.out.println(", content " + e.getContent());
		}

		messages = messageDAOImple.userMessages(2); // list of messages belong to user 2
		System.out.println("list of messages belongs to user id=2");
		for (Message e : messages){
			System.out.print("id " + e.getId());
			System.out.print(", user_id " + e.getUserId());
			System.out.print(", title " + e.getUserId());
			System.out.println(", content " + e.getContent());
		}
		System.out.println(" the number of messages belong to user id=2 : "+messageDAOImple.countMessages(2)); // count number of messages belong to user 2
		for(int i=1;i<5;i++){
			messageDAOImple.delMessage(i);//delate mesage of id i
		}
		System.out.println("list of messages after deleted 4 of them");

		messages = messageDAOImple.listMessage(); //list of all messages
		for (Message e : messages){
			System.out.print("id " + e.getId());
			System.out.print(", user_id " + e.getUserId());
			System.out.print(", title " + e.getUserId());
			System.out.println(", content " + e.getContent());
		}
	}

}
