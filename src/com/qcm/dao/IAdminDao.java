package com.qcm.dao;

import java.util.List;

import com.qcm.entity.Admin;
import com.qcm.entity.Counter;

public interface IAdminDao {

	/**
	 * 检查管理员登录，密码是否正确
	 * @author 裘丛民
	 * */
	public boolean checkAdmin(Admin admin);

	/**
	 * 搜索特定状态(0是冻结，1是启用)的用户， 从start开始的number个用户
	 * 
	 * @author 裘丛民
	 * */
	public List<Counter> counterList(int start, int number, int state);

	/**
	 * 显示从start开始的number个用户
	 * 
	 * @author 裘丛民
	 * */
	public List<Counter> counterList(int start, int number);

	/**
	 * 重置用户密码
	 * 
	 * @author 裘丛民
	 * */
	public boolean resetCounterPwd(Counter counter);

	/**
	 * 冻结某用户
	 * 
	 * @author 裘丛民
	 * */
	public boolean freezeCounter(Integer id);

	/**
	 * 启用某用户
	 * 
	 * @author 裘丛民
	 * */
	public boolean warmCounter(Integer id);

	/**
	 * 统计用户数量
	 * 
	 * @author 裘丛民
	 * */
	public int countCounter();

	/**
	 * 根据id获取用户
	 * 
	 * @author 裘丛民
	 * */
	public Counter getCounterById(Integer id);
}
