package com.qcm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qcm.constant.Constant;
import com.qcm.dao.ICounterDao;
import com.qcm.entity.Admin;
import com.qcm.entity.Counter;
import com.qcm.util.PwdSecurityUtil;

public class CounterDaoImpl  implements ICounterDao{
	private SessionFactory sessionFactory;
	@Override
	public boolean info(String userName) {
		return false;
	}

	@Override
	public boolean update(Counter counter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePwd(String userName, String passWord,
			String newpassWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	
	public boolean saveCounter(Counter counter) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(counter);
		transaction.commit();
		session.close();
		return true;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean canlogin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			
			String hql ="from Counter as ct  where ct.userName=? and ct.userPassword=? ";
			Query query=session.createQuery(hql);
			query.setString(0,admin.getAdminName());
			query.setString(1, PwdSecurityUtil.transMd5(admin.getAdminPassword(), Constant.PWD_COUNT));
			List<Admin> list=query.list();
			if (list.size() >= 1){
				
				return true;
			}
			
			
			
			transaction.commit();
			session.close();
		}catch (Exception e) {
			// TODO: handle exception
		
			
		}
		return false;
		
	}
	

}
