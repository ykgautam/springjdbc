package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.JdbcConfig;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * insert update delete change operations using spring jdbc
 */

public class App {

	public static void main(String[] args) {
		System.out.println("program started");

//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

//		this is for without xml file
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//		--------------------------------------------------------------------
//					insert
//		Student student = new Student();
//		student.setId(444);
//		student.setName("John");
//		student.setCity("Pune");
//		int result = studentDao.insert(student);
//		System.out.println("student added " + result);
//		----------------------------------------------------------------------------------
//					change
//		Student student = new Student();
//		student.setId(111);
//		student.setName("Yashkumar");
//		student.setCity("Kanpur");
//		int result = studentDao.change(student);
//		System.out.println("data changed " + result);

//		-----------------------------------------------------------------------------------
//					delete
//		Student student = new Student();
//		student.setId(444);
//		int deleteCount = studentDao.delete(student.getId());
//		System.out.println("data deleted " + deleteCount);
// 		-----------------------------------------------------------------------------------
//					update
////	System.out.println(template);
////    	insert query
//		String query = "insert into student(id,name,city) values(?,?,?)";
////    	fire the query
//		int result = template.update(query, 333, "Mohit Kumar", "kanpur");
//		System.out.println("number of record inserted... " + result);

//		----------------------------------------------------
//		Student student = studentDao.getStudent(333);
//		System.out.println(student);

//		----------------------------------------------------
		List<Student> allStudents = studentDao.getAllStudents();
		for (Student s : allStudents) {
			System.out.println(s);
		}

//		for (Iterator iterator = allStudents.iterator(); iterator.hasNext();) {
//			Student student = (Student) iterator.next();
//			System.out.println(student);
//		}

		context.close();

	}
}