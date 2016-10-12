package org.elearning.portfolio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	}

}
