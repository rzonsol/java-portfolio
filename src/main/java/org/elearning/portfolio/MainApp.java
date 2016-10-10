package org.elearning.portfolio;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.elearning.portfolio.StudentJDBCTemplate;



/**
 * Created by rzonsol on 09.10.2016.
 */



public class MainApp {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext(
                "spring-module.xml");

        StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");


        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", LOGIN : " + record.getLogin() );
            System.out.println(", EMAIL : " + record.getEmail());
        }
    }
}
