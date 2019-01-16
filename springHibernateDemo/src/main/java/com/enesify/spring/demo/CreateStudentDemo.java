package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enesify.spring.demo.entity.Student;

public class CreateStudentDemo {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create a student object
			LOGGER.info("Creating new student object...");
			
			Student newStudent = new Student("Paul","Wall","paul@haul.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			LOGGER.info("Saving the student...");
			session.save(newStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			LOGGER.info("Done!");
			
		} 
		
		catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		
		finally {
			factory.close();
		}

	}

}
