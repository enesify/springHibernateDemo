package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enesify.spring.demo.entity.Student;

public class CreateSession {

	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static SessionFactory factory;

	private static Session session;

	public CreateSession() {
		try {
			LOGGER.info("Session creating...");
			startSession();
			LOGGER.info("Session created...");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
	}

	public static void startSession() {
		// create session factory
		try {
			factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		} catch (HibernateException ex) {
			LOGGER.error(ex.getMessage());
		}

		// create session
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			LOGGER.error(ex.getMessage());
		}
	}

	public void closeSessionFactory() {
		LOGGER.info("Trying to close session...");
		try {
			factory.close();
			LOGGER.info("Session closed successfully...");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		CreateSession.factory = factory;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		CreateSession.session = session;
	}

}
