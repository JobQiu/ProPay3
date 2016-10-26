package com.qcm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"classpath:springmvc-servlet.xml");
		SessionFactory sessionFactory = applicationContext.getBean(
				SessionFactory.class, "sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		transaction.commit();
		session.close();
	}
}
