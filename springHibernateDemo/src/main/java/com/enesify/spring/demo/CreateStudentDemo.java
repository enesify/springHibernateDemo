package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enesify.spring.demo.entity.Student;

public class CreateStudentDemo {

	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static SessionFactory sessionFactory;

	public static Session session;

	public static CreateSession createSession;

	public static void main(String[] args) {

		createSession = new CreateSession();

		sessionFactory = createSession.getFactory();

		session = createSession.getSession();

		saveStudent();

	}

	public static void saveStudent() {
		try {
			// create a student object
			LOGGER.info("Creating new student object...");

			Student newStudent = new Student("Paul", "Wall", "paul@haul.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			LOGGER.info("Saving the student...");
			session.save(newStudent);

			// commit transaction
			session.getTransaction().commit();

			LOGGER.info("Done!");

		}

		catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		finally {
			createSession.closeSessionFactory();
		}
	}
}
