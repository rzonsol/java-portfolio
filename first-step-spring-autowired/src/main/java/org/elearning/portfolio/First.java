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


	}

}
