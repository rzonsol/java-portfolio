package org.elearning.portfolio;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import java.util.List;
import java.util.ArrayList;
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

		Role rol1 = new Role();
		Role rol2 =new Role();
		rol1.setRoleName("Admin");
		rol2.setRoleName("User");
//		rol1.setRoleId(1);
		List<Role> roles = new ArrayList<Role>();
		roles.add(rol1);
		ser.addUser("login","email", "imie", "nazwisko",roles);
		ser.delUser(2);

//		ser.addUserRole(1,rol2);
//		List<User> users = ser.getUsers();
//		for(User u:users){
//			System.out.println(u.getId());
//			System.out.println(u.getEmail());
//			System.out.println(u.getFirstName());
//			System.out.println(u.getLastName());
//			for(Role r :u.getRoles()) {
//				System.out.println(r.getRoleName());
//			}
//		}
//		System.out.println(roles.get(0).getRoleName());
//
//		ser.addRole(rol1);
//		List<Role> roles1 = ser.getUserRoles(1);

//		System.out.println(roles1);
//		for(Role r:roles1){
//			System.out.println(r.getRoleId());
//			System.out.println(r.getRoleName());
//		}

		List<Role> roles2 = ser.getUserRoles(1);
		for(Role r:roles2){
			System.out.println("role id: "+r.getRoleId());
			System.out.println("role name: "+r.getRoleName());
			System.out.println("user id: "+r.getUserId());
		}
	}

}
