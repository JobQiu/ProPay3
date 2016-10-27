package com.qcm.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.qcm.entity.News;
import com.qcm.entity.SplitPage;

public class NewsDaoImpl {
	private SessionFactory sessionFactory;
	private News news;

	public String showNews(SplitPage splitPage) {
		// 开启session
		Session session = sessionFactory.openSession();
		// 执行数据操作
		String sql1 = "select * from news where title like '%"
				+ splitPage.getTitleKey() + "%'";
		String sql = sql1 + " limit "
				+ (splitPage.getCurPage() - 1) * splitPage.getPageSize() + ","
				+ splitPage.getPageSize();
		// 总数据
		List<News> listss = session.createSQLQuery(sql1).list();
		splitPage.setTotalNum(listss.size());
		// 分页数据
		@SuppressWarnings("unchecked")
		List<News> lists = session
				.createCriteria(News.class)
				.add(Restrictions.like("title", "%" + splitPage.getTitleKey() + "%"))
				.setFirstResult(
						(splitPage.getCurPage() - 1) * splitPage.getPageSize())
				.setMaxResults(splitPage.getPageSize()).list();
		
		splitPage.setList(lists);

		// 关闭session及session工厂
		session.close();

		// 对数据进行判断

		return "manager/tab/tab_admin";
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * // 1.读取配置文件 ApplicationContext applicationContext = new
	 * FileSystemXmlApplicationContext( "src/springmvc-servlet.xml"); //
	 * 2.获取session工厂 SessionFactory sessionFactory = applicationContext.getBean(
	 * "sessionFactory", SessionFactory.class); // 3.开启session Session session =
	 * sessionFactory.openSession(); // 4.开启事务 Transaction transaction =
	 * session.beginTransaction(); // 5.执行数据操作 News news = new News();
	 * news.setText("!23"); news.setAbstract_("123"); news.setTitle("haha");
	 * 
	 * @SuppressWarnings("deprecation") Timestamp time = new Timestamp(2016, 10,
	 * 25, 9, 33, 20, 30); news.setTime(time);
	 * 
	 * News news2 = new News(); news2.setId(1); // session.delete(news2); //
	 * session.save(news);
	 * 
	 * List<News> lists = session.createSQLQuery("select * from news").list();
	 * for(int i = 0;i < lists.size();i++){ System.out.println(lists.get(i)); }
	 * 
	 * 
	 * List<News> list =
	 * session.createCriteria(News.class).add(Restrictions.eq("id", 1)).list();
	 * System.out.println(list.get(0).getTitle());
	 * 
	 * List<News> news4 = session.createQuery("from News where id = :id")
	 * .setInteger("id", 1).list(); System.out.println(news4.get(0).getTitle());
	 * List<News> lists = session.createCriteria(News.class).setFirstResult(1)
	 * .setMaxResults(2).list(); System.out.println(lists.size()); // 6.提交事务
	 * transaction.commit(); // 7.关闭session session.close(); // 8.关闭session工厂
	 * sessionFactory.close(); System.out.println("123"); }
	 */

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
