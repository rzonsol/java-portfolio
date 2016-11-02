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
//		user.setId(50);
//
//		session.beginTransaction();
//		session.delete(user);
//		session.getTransaction().commit();
//		final List<User> users = session.createCriteria(User.class).list();
//
//		session.close();
//		factory.close();

//		ser.addUser("login1","mail1", "firstName 1", "last name ");
//		ser.delUser(47);
		List<User> users1 = ser.getUsers();

		for ( User b : users1) {
			System.out.println(b.getLogin());
			System.out.println(b.getLastName());
			System.out.println(b.getEmail());
			System.out.println(b.getId());
		}
//		User b = ser.getUser(51);
//		System.out.println(b.getLogin());
//		System.out.println(b.getLastName());
//		System.out.println(b.getEmail());
//		System.out.println(b.getId());

		messag.delMessage(7);
		System.out.println("\n----\n");
		List<Message> messages =  messag.getUserMessages(1);
		for( Message m : messages){
			System.out.println(m.getId());
			System.out.println(m.getTitle());
		}
	}

}
