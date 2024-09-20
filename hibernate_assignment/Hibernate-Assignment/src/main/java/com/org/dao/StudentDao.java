package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Student;

public class StudentDao {
	
	EntityManagerFactory emf;
	
	{
       emf = Persistence.createEntityManagerFactory("karthik");
		
		
	}
	
	
	
	
	
	public void insertStudent(Student std) {
		
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(std);
		
		et.commit();
		
		
		
		
	}
	
	
	
	public Student fetchStudentById(int id) {
		
		
EntityManager em = emf.createEntityManager();
		

		
		Student student = em.find(Student.class, id);
		
		
		return student;
	
		
	}

	
	
	public Student removeStudentById(int id) {


		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student student = em.find(Student.class, id);
		
		et.begin();
		em.remove(student);
		
		et.commit();
		
		return student;
		
		
	}
	
	
	
	
	public void updateStudent(Student std) {
		
		
EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(std);
		
		et.commit();
		
		
		
		
	}
}
