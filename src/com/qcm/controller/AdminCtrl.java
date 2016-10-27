package com.qcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcm.constant.Constant;
import com.qcm.dao.impl.AdminDaoImpl;
import com.qcm.entity.Counter;
import com.qcm.util.SendMailUtil;

@Controller
@RequestMapping("/admin")
public class AdminCtrl {

	@Resource
	private AdminDaoImpl a;
	@Resource
	private Counter counter;

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

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

		// 2.向用户发送提示，已被冻结
		String subject = "Your counter has been freezed!";
		Counter counter2 = a.getCounterById(id);
		String content = "亲爱的" + counter2.getCardName()
				+ ",您的账户已被冻结，请与管理员联系。";
		String receptor = counter2.getUserEmail();
		System.out.println("email address is \t" + receptor);
		SendMailUtil sendMailUtil = new SendMailUtil(receptor, subject, content);
		sendMailUtil.start();
		

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
	public String resetPwd(HttpSession session, Integer id) {
		counter.setId(id);
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

		// 2.向用户发送提示，已被冻结
		String subject = "ProPra Reset Code";
		Counter counter2 = a.getCounterById(id);
		String content = "亲爱的" + counter2.getCardName()
				+ ",请点此<a href=\"http://localhost:8080/test/admin/reset?id="
				+ id + "\">重置密码</a>";
		String receptor = counter2.getUserEmail();
		System.out.println("email address is \t" + receptor);
		SendMailUtil sendMailUtil = new SendMailUtil(receptor, subject, content);
		sendMailUtil.start();

		return "/manager/tab/tab_admin_manaUser";
	}

	@RequestMapping("reset")
	public String reset(HttpSession httpSession, Integer id) {
		System.out.println("id=" + id);
		Counter counter2 = a.getCounterById(id);
		httpSession.setAttribute("counter", counter2);
		return "/manager/tab/resetPwd";
	}

	@RequestMapping("resetP")
	public String resetP(HttpSession httpSession, String password) {
		counter = (Counter) httpSession.getAttribute("counter");
		counter.setUserPassword(password);
		a.resetCounterPwd(counter);
		return "/manager/tab/success";
	}

	@RequestMapping("/searchC")
	public @ResponseBody
	List<String> searchC(String counter, String name) {
		System.out.println(name + "the left is name and the right is counter "
				+ counter);
		List<Counter> counters = a.searchFuzzy(counter, name);
		List<String> strings = new ArrayList<String>();
		for (Counter counter2 : counters) {
			strings.add(counter2.toString());
		}
		return strings;
	}

}
