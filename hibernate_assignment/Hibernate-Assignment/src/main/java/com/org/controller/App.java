package com.org.controller;

import java.util.Scanner;

import com.org.dao.StudentDao;
import com.org.dto.Student;

public class App {

	public static void main(String[] args) {

		App app = new App();
		app.crud();

	}

	public void crud() {

		System.out.println("**********HOMEPAGE**********");
		System.out.println("1. Create Student");
		System.out.println("2. Fetch Student");
		System.out.println("3. Remove Student");
		System.out.println("4. Update Student");
		System.out.println("5. Exit");
		System.out.println("Choose Any of the option");
		Scanner os = new Scanner(System.in);
		int val1 = os.nextInt();
		switch (val1) {
		case 1: {

			studentInsert();
			System.out.println("Student Details Inserted Successfully");

			break;

		}

		case 2: {

			studentFetch();

			break;

		}

		case 3: {
			deleteStudent();
			System.out.println("Student Details deleted");

			break;

		}

		case 4: {

			StudentDao dao = new StudentDao();

			System.out.println("Enter the Id: ");

			int id = os.nextInt();

			Student std = dao.fetchStudentById(id);

			System.out.println("Choose any of the following to update");
			System.out.println("1. Student Name");
			System.out.println("2. Student Age");
			System.out.println("3. Student Email");
			System.out.println("4. Student Password");
			System.out.println("5. Update All");
			int key = os.nextInt();

			switch (key) {
			case 1:
				System.out.println("Enter the name");

				String name = os.next();
				std.setName(name);

				dao.updateStudent(std);

				System.out.println("Student name Updated");

				break;
			case 2:

				System.out.println("Enter the Age");

				int age = os.nextInt();
				std.setAge(age);

				dao.updateStudent(std);

				System.out.println("Student age Updated");

				break;
			case 3:
				System.out.println("Enter the email");

				String email = os.next();
				std.setName(email);

				dao.updateStudent(std);

				System.out.println("Student email Updated");

				break;
			case 4:
				System.out.println("Enter the password");

				String password = os.next();
				std.setName(password);

				dao.updateStudent(std);

				System.out.println("Student password Updated");

				break;
			case 5:
				
				updateStudent(id);
				System.out.println("Students Details Updated");

				break;

			default:
				break;
			}
			break;

		}

		case 5: {
			System.out.println("Exited......");
			return;
		}
		default:
			System.out.println("Invalid Data");
		}
		crud();

	}

	public void studentInsert() {

		StudentDao dao = new StudentDao();
		Scanner os = new Scanner(System.in);
		Student std = new Student();
		System.out.println("Enter ID: ");

		int id = os.nextInt();

		System.out.println("Enter your name: ");

		os.nextLine();

		String name = os.nextLine();

		System.out.println("Enter your age: ");

		int age = os.nextInt();

		System.out.println("Enter your email: ");

		os.nextLine();

		String email = os.nextLine();

		System.out.println("Enter your password: ");

		String password = os.nextLine();

		std.setId(id);
		std.setName(name);
		std.setAge(age);
		std.setEmail(email);
		std.setPassword(password);

		dao.insertStudent(std);

	}

	public void studentFetch() {

		StudentDao dao = new StudentDao();
		Scanner os = new Scanner(System.in);

		System.out.println("Enter the Id: ");

		int id = os.nextInt();

		Student std = dao.fetchStudentById(id);

		if (std != null) {
			System.out.println("Student id:" + std.getId());
			System.out.println("Student name:" + std.getName());
			System.out.println("Student age:" + std.getAge());
			System.out.println("Student email:" + std.getEmail());
			System.out.println("Student password:" + std.getPassword());
		}

		else
			System.out.println("404 NOT FOUND");

	}

	public void deleteStudent() {

		StudentDao dao = new StudentDao();
		Scanner os = new Scanner(System.in);

		System.out.println("Enter the Id: ");

		int id = os.nextInt();

		dao.removeStudentById(id);

	}

	public void updateStudent(int id) {

		StudentDao dao = new StudentDao();
		Scanner os = new Scanner(System.in);
		Student std = dao.fetchStudentById(id);
		
		System.out.println("Enter your name: ");

		os.nextLine();

		String name = os.nextLine();

		System.out.println("Enter your age: ");

		int age = os.nextInt();

		System.out.println("Enter your email: ");

		os.nextLine();

		String email = os.nextLine();

		System.out.println("Enter your password: ");

		String password = os.nextLine();

		
		std.setName(name);
		std.setAge(age);
		std.setEmail(email);
		std.setPassword(password);

		dao.updateStudent(std);

	}

}
