package com.qcm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.constant.Constant;
import com.qcm.dao.impl.AdminDaoImpl;
import com.qcm.dao.impl.CounterDaoImpl;
import com.qcm.entity.Admin;
import com.qcm.entity.Counter;
import com.qcm.util.PwdSecurityUtil;

@Controller
public class LoginAndRegister {
	public static String POWER="counter";
	public static String REMEMBER = "remember";
	@Resource
	private CounterDaoImpl  counterDaoImpl;
	@Resource
	private AdminDaoImpl adminDaoImpl;
	@RequestMapping(value="/login")
	public String login(HttpServletRequest req,@ModelAttribute Admin admin,HttpSession session){
		//获取单选的值
		String power = req.getParameter("power");
		String remember = req.getParameter("remember");
		System.out.println(power);
		System.out.println(remember);
		if(POWER.equals(power)){
			System.out.println(admin.getAdminName()+"==="+admin.getAdminPassword());
			if(counterDaoImpl.canlogin(admin)){
				if(REMEMBER.equals("remember")){
					session.setAttribute("admin", admin);
				}
				return "forward:/hello.jsp";
			}else{
				req.getSession().setAttribute("info", "用户名或密码错误!");
				return "forward:/index.jsp";
			}
		}else{
			System.out.println(admin.getAdminName()+"==="+admin.getAdminPassword());
			if(adminDaoImpl.checkAdmin(admin)){
				return "forward:/hello.jsp";
			}else{
				req.getSession().setAttribute("info", "用户名或密码错误!");
				return "forward:/index.jsp";
			}
		}
	}
	@RequestMapping(value="/register")
	public String register(@ModelAttribute Counter counter ,Model m){
		System.out.println(counter.getUserName()+"======"+counter.getUserPassword());
		counter.setUserPassword(PwdSecurityUtil.transMd5(counter.getUserPassword(), Constant.PWD_COUNT));
		System.out.println(counter.getUserPassword());
		counterDaoImpl.saveCounter(counter);
		m.addAttribute("username", counter.getUserName());
			return "forward:/index.jsp";
	}
	@RequestMapping(value="/canRegister")
	public void canRegister(String userName,HttpServletResponse resp){
		boolean result = counterDaoImpl.info(userName);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.flush();
		out.close();
	}
	
	public CounterDaoImpl getCounterDaoImpl() {
		return counterDaoImpl;
	}
	public void setCounterDaoImpl(CounterDaoImpl counterDaoImpl) {
		this.counterDaoImpl = counterDaoImpl;
	}
	public AdminDaoImpl getAdminDaoImpl() {
		return adminDaoImpl;
	}
	public void setAdminDaoImpl(AdminDaoImpl adminDaoImpl) {
		this.adminDaoImpl = adminDaoImpl;
	}

	
	

	
}
