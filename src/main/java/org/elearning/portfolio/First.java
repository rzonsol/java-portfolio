package org.elearning.portfolio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.elearning.portfolio.bean.FirstBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class First {

	private static ApplicationContext context;

	public static void main(String[] args) {
	    JFrame parent = new JFrame();

	    JOptionPane.showMessageDialog(parent, "Hello World");
	    
	    context = new ClassPathXmlApplicationContext(
				"spring-module.xml");

		FirstBean obj = (FirstBean) context.getBean("helloBean");
		obj.exexute();
	}

}
