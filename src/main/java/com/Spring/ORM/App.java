package com.Spring.ORM;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.ORM.dao.StudentDao;
import com.Spring.ORM.entities.Student;
import com.mysql.cj.Session;

/**
 * Hello world!
 *
 */
public class App {

	private static Scanner sc = new Scanner(System.in);

	public static int menuDriven() {

		System.out.println("0 :- EXIT ");
		System.out.println("1 :- Adding Student");
		System.out.println("2 :- Get details of Single Student");
		System.out.println("3 :- Deleting Student");
		System.out.println("4 :- Update Student");

		return sc.nextInt();
	}

	private static void setStudent(Student std) {

		System.out.println("Enter Stduent Id : -");
		std.setStd_id(sc.nextInt());
		System.out.println("Enter Stduent Name : -");
		std.setStd_name(sc.next());
		System.out.println("Enter Stduent City : -");
		std.setStd_city(sc.next());

	}

	private static void getStudent(Student std) {

		System.out.println("Enter student id : - ");
		std.setStd_id(sc.nextInt());

	}

	private static void deleteStudent(Student std) {
		System.out.println("Put Studnt Id for deleting :- ");
		std.setStd_id(sc.nextInt());

	}

	private static void updateRecord(Student std) {

		System.out.println("Enter to Update Studnet ID :- ");
		std.setStd_id(sc.nextInt());
		System.out.println("Enter to Update Studnet Name :- ");
		std.setStd_name(sc.next());
		System.out.println("Enter to Update Studnet City :- ");
		std.setStd_city(sc.next());

	}

	public static void main(String[] args) {

		System.out.println("**** WELCOME TO SPRING ORM PROJECT ****");

		ApplicationContext contex = new ClassPathXmlApplicationContext("com/Spring/ORM/ormconfig.xml");
		StudentDao dao = contex.getBean("studentDao", StudentDao.class);
//		Student student2 = dao.getStudent(13);
//		System.out.println("Show " + student2);

		int choice;

		while ((choice = App.menuDriven()) != 0) {
			Student std;

			switch (choice) {
			case 1:

				// ------------ add new Studnet ------------
				std = new Student();
				App.setStudent(std);

				if (std != null) {
					int insert = dao.insert(std);
					System.out.println("Data Inserted" + insert);
					System.out.println("*** Case 1 DONE ****");

				}
				break;

			case 2:

				// ------------ get All Stduent data ------------
				std = new Student();
				App.getStudent(std);

				if (std != null) {
					List<Student> allStduents = dao.getAllStduents();

					for (Student student : allStduents) {
						System.out.println(" Show Students := " + student);
						System.out.println("*** Case 2 DONE ****");

					}
				}

				break;

			case 3:

				// ------------ delete Stduent ------------
				std = new Student();
				App.deleteStudent(std);

				if (std != null) {
					dao.delete(std);
					System.out.println("Student Deleted");
					System.out.println("**** Case 3 DONE ****");

				}
				break;

			case 4:

				// ------------ Updating Stduent ------------
				std = new Student();
				if (std != null) {
					App.updateRecord(std);

					dao.update(std);
					System.out.println("Data UPDATE");
					System.out.println("*** Case 4 DONE ****");
				}

				break;
			}
			
			System.out.println("*** Exit ***");
		}

	}
}
