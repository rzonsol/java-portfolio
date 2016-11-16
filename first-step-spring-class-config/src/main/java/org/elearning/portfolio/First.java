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

	}
}



