package com.qcm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.constant.Constant;
import com.qcm.dao.impl.AdminDaoImpl;
import com.qcm.entity.Counter;

@Controller
@RequestMapping("/admin")
public class AdminCtrl {

	@Resource
	private AdminDaoImpl a;

	public AdminDaoImpl getA() {
		return a;
	}

	public void setA(AdminDaoImpl a) {
		this.a = a;
	}

	@RequestMapping("/showUsers")
	public String hello(HttpSession session, Integer curPage) {
		if (curPage == null)
			curPage = 1;
		List<Counter> counters = a.counterList(curPage, Constant.PAGE_NUMBER);
		session.setAttribute("counters", counters);
		Map<String, Object> splitPage = new HashMap<String, Object>();
		splitPage.put("totalNum", a.countCounter());

		splitPage.put("curPage", curPage);
		splitPage.put("maxPage", a.countCounter() / Constant.PAGE_NUMBER + 1);

		session.setAttribute("splitPage", splitPage);
		return "/manager/tab/tab_admin_manaUser";
	}

	@RequestMapping("/freezeUser")
	public String freeze(HttpSession session, Integer id) {
		a.freezeCounter(id);
		Integer curPage = (Integer) session.getAttribute("curPage");
		if (curPage == null)
			curPage = 1;
		List<Counter> counters = a.counterList(1, Constant.PAGE_NUMBER);
		session.setAttribute("counters", counters);
		Map<String, Object> splitPage = new HashMap<String, Object>();
		splitPage.put("totalNum", a.countCounter());

		splitPage.put("curPage", curPage);
		splitPage.put("maxPage", a.countCounter() / Constant.PAGE_NUMBER + 1);

		session.setAttribute("splitPage", splitPage);
		return "/manager/tab/tab_admin_manaUser";
	}

	@RequestMapping("/warmUser")
	public String warm(HttpSession session, Integer id) {
		a.warmCounter(id);
		Integer curPage = (Integer) session.getAttribute("curPage");
		if (curPage == null)
			curPage = 1;
		List<Counter> counters = a.counterList(1, Constant.PAGE_NUMBER);
		session.setAttribute("counters", counters);
		Map<String, Object> splitPage = new HashMap<String, Object>();
		splitPage.put("totalNum", a.countCounter());

		splitPage.put("curPage", curPage);
		splitPage.put("maxPage", a.countCounter() / Constant.PAGE_NUMBER + 1);

		session.setAttribute("splitPage", splitPage);
		return "/manager/tab/tab_admin_manaUser";
	}

	@RequestMapping("/resetPwd")
	public String resetPwd() {
		return "/manager/tab/tab_admin_resetUserCode";
	}
}
