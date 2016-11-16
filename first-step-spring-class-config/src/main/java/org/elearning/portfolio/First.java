package org.elearning.portfolio;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.elearning.portfolio.user.*;
import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.*;

import java.util.ArrayList;
import java.util.List;


public class First {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigBean.class);
		ctx.refresh();

		UserService ser = (UserService)ctx.getBean("userService");
		MessageService messag = (MessageService)ctx.getBean("messageService");
//		Role rol1 = new Role();
//		Role rol2 = new Role();
//
//		rol1.setRoleName("Admin");
//		rol2.setRoleName("User");
//		List<Role> roles1 = new ArrayList<Role>();
//		roles1.add(rol1);
//		roles1.add(rol2);
//
//		ser.addUser("login","gdjhagj@ldjshf", "piotr", "rzonsol",roles1);
//
//		List<User> users = ser.getUsers(); //list of all users
//		System.out.println(users);
//		System.out.println("list of users");
//
////		User e =users.get(0);
//		for (User e : users){
//			System.out.print("id " + e.getId());
//			System.out.print(", login " + e.getLogin());
//			System.out.print(", email " + e.getEmail());
//			System.out.print(", firstName " + e.getFirstName());
//			System.out.println(", lastName " + e.getLastName());
//			System.out.println(", Roles " + e.getRoles());
//		}
//
//		List<Role> roles = ser.getUserRoles(15);
//
//		for(Role r :roles){
//			System.out.println("role id: "+r.getRoleId());
//			System.out.println("role name: "+r.getRoleName());
//			System.out.println("user id: "+r.getUserId());
//		}

//		Role rol3= new Role();
//		rol3.setRoleName("Moderator");
//		ser.addUserRole(15,rol3);
//
//		User user = ser.getUser(15);
//		System.out.print("id " + user.getId());
//		System.out.print(", login " + user.getLogin());
//		System.out.print(", email " + user.getEmail());
//		System.out.print(", firstName " + user.getFirstName());
//		System.out.println(", lastName " + user.getLastName());
//		for(Role r:user.getRoles()){
//			System.out.println("role id: "+r.getRoleId());
//			System.out.println("role name: "+r.getRoleName());
//			System.out.println("user id: "+r.getUserId());
//		}

//		ser.delUser(1);
//		messag.createMessage(2,"test","test");
//		messag.createMessage(2,"test2","test2");
//		messag.createMessage(2,"test3","test3");
//
//		List<Message> messages = messag.getMessages(); //list of all messages
//		System.out.println("list of messages");
//		for (Message e : messages){
//			System.out.print("id " + e.getId());
//			System.out.print(", user_id " + e.getUserId());
//			System.out.print(", title " + e.getUserId());
//			System.out.println(", content " + e.getContent());
//		}

		messag.createMessage(15,"to jest to","jbsdjfb js bdkfjhsb djhbv ");
		messag.delMessage(1);
		List<Message> messages = messag.getMessages();
		for(Message m : messages){
			System.out.println("message id"+m.getId());
			System.out.println("message title"+m.getTitle());
		}
	}
}



