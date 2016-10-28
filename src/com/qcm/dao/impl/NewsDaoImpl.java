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

	/*
	 * 新闻查询
	 */
	public String showNews(SplitPage splitPage) {
		// 开启session
		Session session = sessionFactory.openSession();
		// 执行数据操作
		String sql1 = "select * from news where title like '%"
				+ splitPage.getTitleKey() + "%'";
		String sql = sql1 + " limit " + (splitPage.getCurPage() - 1)
				* splitPage.getPageSize() + "," + splitPage.getPageSize();
		// 总数据
		List<News> listss = session.createSQLQuery(sql1).list();
		splitPage.setTotalNum(listss.size());
		// 分页数据
		@SuppressWarnings("unchecked")
		List<News> lists = session
				.createCriteria(News.class)
				.add(Restrictions.like("title", "%" + splitPage.getTitleKey()
						+ "%"))
				.setFirstResult(
						(splitPage.getCurPage() - 1) * splitPage.getPageSize())
				.setMaxResults(splitPage.getPageSize()).list();

		splitPage.setList(lists);

		// 关闭session
		session.close();

		// 对数据进行判断
		return "manager/news_admin";
	}

	/*
	 * 新闻添加
	 */
	public void addNews(News news) {
		// 开启session
		Session session = sessionFactory.openSession();
		// 执行数据操作
		session.save(news);
		// 关闭session及session工厂
		session.close();
	}
	
	/*
	 * 新闻修改
	 */
	public void editNews(News news) {
		// 开启session
		Session session = sessionFactory.openSession();
		// 执行数据操作
		session.update(news);
		// 关闭session及session工厂
		session.close();
	}

	/*
	 * 新闻删除
	 */
	public void delNews(String number) {
		// 开启session
		Session session = sessionFactory.openSession();
		// 执行数据操作
		String[] ids = number.split(",");
		for(int i = 0;i < ids.length;i++){
			int id = Integer.parseInt(ids[i]);
			news.setId(id);
			session.delete(news);
		}
		// 关闭session及session工厂
		session.close();
	}

	
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
