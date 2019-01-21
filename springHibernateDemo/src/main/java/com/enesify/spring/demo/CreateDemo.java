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
		
		createSession = new CreateSession(Instructor.class,InstructorDetail.class);

		session = CreateSession.getSession();

		saveStudent();

	}

	public static void saveStudent() {
		try {
			// create an object
			LOGGER.info("Creating new objects...");
			
			Instructor instructor = new Instructor();
			InstructorDetail instructorDetail = new InstructorDetail();
			
			instructor.setFirstName("Enes");
			instructor.setLastName("Batur");
			instructor.setEmail("enes@enesify.com");
			
			instructorDetail.setHobby("Swimming");
			instructorDetail.setYoutubeChannel("https://www.youtube.com/enesitube");
			
			//associate the objects
			instructor.setInstructorDetail(instructorDetail);

			//Student newStudent = new Student("Paul", "Wall", "paul@haul.com");

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//Note: this will ALSO save the details object because of CascadeType.ALL
			LOGGER.info("Saving the instructors...");
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();

			LOGGER.info("Done!");

		}

		catch (Exception ex) {
			LOGGER.error(ex.getLocalizedMessage());
		}

		finally {
			createSession.closeSessionFactory();
		}
	}
}
