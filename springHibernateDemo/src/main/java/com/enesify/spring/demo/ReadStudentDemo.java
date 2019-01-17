package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enesify.spring.demo.entity.Student;

public class ReadStudentDemo {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static Session session;

	private static CreateSession createSession;

	public static void main(String[] args) {

		createSession = new CreateSession();

		SessionFactory sessionFactory = createSession.getFactory();

		session = sessionFactory.getCurrentSession();

		readStudent();

	}

	public static void readStudent() {
		try {
			// create a student object
			LOGGER.info("Retrieving student...");

			// start a transaction
			session.beginTransaction();

			Student myStudent = session.get(Student.class, 1);
			
			LOGGER.info(myStudent.toString());

		}

		catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		finally {
			createSession.closeSessionFactory();
		}
	}
}
