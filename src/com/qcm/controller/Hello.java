package com.qcm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.constant.Constant;
import com.qcm.dao.impl.AdminDaoImpl;
import com.qcm.entity.Admin;
import com.qcm.entity.Counter;

@Controller
public class Hello {
	private AdminDaoImpl a;

	public AdminDaoImpl getA() {
		return a;
	}

	public void setA(AdminDaoImpl a) {
		this.a = a;
	}

	@RequestMapping("/hello")
	public String hello(HttpSession session, int page) {
		List<Counter> counters = a.counterList(1, Constant.PAGE_NUMBER);
		session.setAttribute("counters", counters);
		Map<String, Object> splitPage = new HashMap<String, Object>();
		splitPage.put("totalNum", a.countCounter());
		splitPage.put("curPage", page);
		splitPage.put("maxPage", a.countCounter() / Constant.PAGE_NUMBER + 1);

		session.setAttribute("splitPage", splitPage);
		return "/manager/tab/tab_admin_manaUser";
	}

	@RequestMapping("/hello2")
	public String hello2() {
		List<Admin> admins = a.getAdmins();
		Admin admin = admins.get(0);
		// session.setAttribute("splitPage", admins);
		return "/manager/tab/tab_admin_manaUser";
	}
}
