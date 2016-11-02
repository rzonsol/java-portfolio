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

		// ---------------------------------------------------------------------
		//hibernate
//		final Configuration configuration = new Configuration().configure();
//		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//		final SessionFactory factory = configuration.buildSessionFactory(builder.build());
//		final Session session = factory.openSession();
//		User user = new User();
//		user.setLogin("rzonsol");
//		user.setLastName("rzonsol");
//		user.setFirstName("piotr");
//		user.setEmail("jasdhf@sdfjkh");
//
//		session.beginTransaction();
//		session.save(user);
//		session.getTransaction().commit();
//		final List<User> users = session.createCriteria(User.class).list();

//		session.close();
//		factory.close();

		List<User> users = ser.getUsers();
		for (final User b : users) {
			System.out.println(b.getLogin());
			System.out.println(b.getLastName());
			System.out.println(b.getEmail());
			System.out.println(b.getId());
		}
		User user = ser.getUser(49);
		System.out.println(user.getLogin());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
		System.out.println(user.getId());
	}

}
