package com.enesify.spring.demo;

import java.lang.invoke.MethodHandles;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSession {

	public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static SessionFactory factory;

	private static Session session;

	//instantiates the createSession object for single annotated class
	public CreateSession(Class<?> annotatedClass) {
		try {
			LOGGER.info("Session creating...");
			startSession(annotatedClass);
			LOGGER.info("Session created...");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
	}
	
	//instantiates the createSession object for two annotated classes
	public CreateSession(Class<?> annotatedClass1,Class<?> annotatedClass2) {
		try {
			LOGGER.info("Session creating...");
			startSession(annotatedClass1, annotatedClass2);
			LOGGER.info("Session created...");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}
	}
	

	//annotates the session factory with single class
	public static void startSession(Class<?> annotatedClass) {
		// create session factory
		try {
			factory = new Configuration().configure().addAnnotatedClass(annotatedClass).buildSessionFactory();
		} catch (Exception ex) {
			//LOGGER.error(ex.getMessage());
			ex.printStackTrace();
		}

		// create session
		try {
			//session.close();
			session = factory.openSession();
		} catch (Exception ex) {
			//LOGGER.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	//annotates the session factory with two classes
		public static void startSession(Class<?> annotatedClass1, Class<?> annotatedClass2 ) {
			// create session factory
			try {
				factory = new Configuration().configure().addAnnotatedClass(annotatedClass1).addAnnotatedClass(annotatedClass2).buildSessionFactory();
			} catch (Exception ex) {
				//LOGGER.error(ex.getMessage());
				ex.printStackTrace();
			}

			// create session
			try {
				//session.close();
				session = factory.openSession();
			} catch (Exception ex) {
				//LOGGER.error(ex.getMessage());
				ex.printStackTrace();
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
