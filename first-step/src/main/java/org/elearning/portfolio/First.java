package org.elearning.portfolio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;

import java.util.List;


public class First {

	private static ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("jaslfhkasdjn");

		context = new ClassPathXmlApplicationContext(
				"spring-module.xml");


		UserDAOImpl userDAOImple =
				(UserDAOImpl)context.getBean("userDAOImpl");


		List<User> users = userDAOImple.getUsers(); //list of all users
		System.out.println("list of users");
		for (User e : users){
			System.out.print("id " + e.getId());
			System.out.print(", login " + e.getLogin());
			System.out.print(", email " + e.getEmail());
			System.out.print(", firstName " + e.getFirstName());
			System.out.println(", lastName " + e.getLastName());
		}

	}

}
