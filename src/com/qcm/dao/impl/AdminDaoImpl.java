package com.qcm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.constant.Constant;
import com.qcm.dao.IAdminDao;
import com.qcm.entity.Admin;
import com.qcm.entity.Counter;
import com.qcm.util.PwdSecurityUtil;

public class AdminDaoImpl implements IAdminDao {
	private SessionFactory sessionFactory;
	/**
	 * 查看所有的用户
	 * 
	 * @author JobQ
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public List<Admin> getAdmins() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Admin> admins = session.createQuery(
				"select distinct a from Admin a").list();

		transaction.commit();
		session.close();
		return admins;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"classpath:springmvc-servlet.xml");
		AdminDaoImpl a = applicationContext.getBean(AdminDaoImpl.class,
				"adminDaoImpl");
		List<Admin> admins = a.getAdmins();
		System.out.println("用户的数量为r" + a.countCounter());
		for (Admin admin : admins) {
			System.out.println(admin.getAdminName());
		}
		Counter counter = new Counter();
		counter.setId(1);
		a.freezeCounter(1);
	}

	public boolean checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// 1. 获得管理员的用户名
		@SuppressWarnings("unchecked")
		List<Admin> admins = session.createQuery(
				"select distinct a from Admin a where admin_name='"
						+ admin.getAdminName() + "' and admin_password='"
						+ admin.getAdminPassword() + "'").list();
		int count = admins.size();

		transaction.commit();
		session.close();
		if (count >= 1)
			return true;
		else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Counter> counterList(int page, int number, int state) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// 1. 获得特定状态的用户
		List<Counter> counters = session
				.createQuery(
						"select distinct c from Counter c where state = "
								+ state)
.setFirstResult((page - 1) * number)
				.setMaxResults(number).list();

		transaction.commit();
		session.close();
		return counters;
	}

	@Override
	public List<Counter> counterList(int page, int number) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// 1. 获得特定状态的用户
		List<Counter> counters = session
				.createQuery("select distinct c from Counter c")
				.setFirstResult((page - 1) * number).setMaxResults(number)
				.list();

		transaction.commit();
		session.close();
		return counters;
	}

	public boolean resetCounterPwd(Counter counter) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// 1. 获得用户
		List<Counter> counters = session.createQuery(
				"select distinct c from Counter c where user_name = "
						+ counter.getUserName()).list();
		if (counters.size() > 0) {
			Counter counter2 = counters.get(0);
			counter2.setUserPassword(PwdSecurityUtil.transMd5("123456",
					Constant.PWD_COUNT));
			System.out.println("密码是" + counter2.getUserPassword());
			session.update(counter2);
			transaction.commit();
			session.close();
			return true;
		} else {
			transaction.commit();
			session.close();
			return false;
		}
	}

	@Override
	public boolean freezeCounter(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Counter counter = session.get(Counter.class, id);
		counter.setState(0);
		transaction.commit();
		session.close();
		return false;
	}

	@Override
	public boolean warmCounter(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Counter counter = session.get(Counter.class, id);
		counter.setState(1);
		transaction.commit();
		session.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int countCounter() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// 1. 获得用户
		List<Counter> counters = session.createQuery(
				"select distinct c from Counter c ").list();
		transaction.commit();
		session.close();
		return counters.size();
	}
}
