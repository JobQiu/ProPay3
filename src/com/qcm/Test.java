package com.qcm;

import com.qcm.util.SendMailUtil;


public class Test {
	public static void main(String[] args) {
		// ApplicationContext applicationContext = new
		// FileSystemXmlApplicationContext(
		// "classpath:springmvc-servlet.xml");
		// SessionFactory sessionFactory = applicationContext.getBean(
		// SessionFactory.class, "sessionFactory");
		// Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		//
		// transaction.commit();
		// session.close();

		SendMailUtil sendMailUtil = new SendMailUtil("m15158008504@163.com",
				"你好，再见", "zhr shi yige ces hi feojiweoioijweifj`");
		sendMailUtil.start();
	}
}
