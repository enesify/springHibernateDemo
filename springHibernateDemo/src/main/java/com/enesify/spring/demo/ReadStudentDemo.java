package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;
import java.util.List;

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

		// start a transaction
		session.beginTransaction();

		// readStudent();
		// queryStudent();
		updateStudent();

	}

	private static void readStudent() {

		try {
			// create a student object
			LOGGER.info("Retrieving student...");

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

	private static void queryStudent() {

		LOGGER.info("Retrieving student...");

		List<Student> studentList = session.createQuery("from Student s where s.email like '%@haul.com'")
				.getResultList();

		printStudentList(studentList);

		studentList = session.createQuery("from Student s where s.firstName = 'Paul' ").getResultList();

		printStudentList(studentList);
	}

	private static void updateStudent() {
		LOGGER.info("Updating student...");

		int studentId = 1;
		Student theStudent = session.get(Student.class, studentId);
		theStudent.setFirstName("Steve");
		session.createQuery("update Student set email = 'stevew@haul.com' where id = " + studentId).executeUpdate();
		session.getTransaction().commit();
	}

	private static void printStudentList(List<Student> studentList) {
		for (Student student : studentList) {
			LOGGER.info(student.toString());
		}
	}
}
