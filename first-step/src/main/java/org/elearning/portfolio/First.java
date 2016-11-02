package org.elearning.portfolio;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import java.util.List;

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

		MessageService messag = (MessageService)context.getBean("messageService");


	}

}
