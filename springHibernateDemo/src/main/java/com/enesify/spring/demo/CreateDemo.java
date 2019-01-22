package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enesify.spring.demo.entity.Instructor;
import com.enesify.spring.demo.entity.InstructorDetail;;;

public class CreateDemo {

	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static Session session;

	private static CreateSession createSession;

	public static void main(String[] args) {

		createSession = new CreateSession(Instructor.class, InstructorDetail.class);

		session = CreateSession.getSession();

		//saveStudent();
		
		//get();
		
		delete();

	}

	private static void delete() {
		try {
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4L);
			InstructorDetail deletedInstructorDetail = instructorDetail;
			
			session.delete(instructorDetail);
			
			session.getTransaction().commit();

			LOGGER.info("Deleted instructor : "+ deletedInstructorDetail.getInstructor().toString());
			LOGGER.info("Deleted instructor detail : "+ deletedInstructorDetail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void get() {
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 4L);
			LOGGER.info(instructor.getInstructorDetail().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void saveStudent() {
		try {
			// create an object
			LOGGER.info("Creating new objects...");

			InstructorDetail instructorDetail = new InstructorDetail("Swimming", "enesitube");
			Instructor instructor = new Instructor("Enes", "Batur", "enes@enesify.com");

			// associate the objects
			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();
			
			// save the instructor
			// Note: this will ALSO save the details object because of CascadeType.ALL
			session.save(instructor);
			
			// LOGGER.info("Saving the instructors...");

			// commit transaction
			session.getTransaction().commit();

			LOGGER.info("Done!");

		}

		catch (Exception ex) {
			// LOGGER.error(ex.getMessage());
			ex.printStackTrace();
		}

		finally {
			session.close();
			createSession.closeSessionFactory();
		}
	}
}
