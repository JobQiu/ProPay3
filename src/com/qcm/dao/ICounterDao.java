package com.qcm.dao;

import java.util.List;

import com.qcm.entity.Admin;
import com.qcm.entity.Counter;

public interface ICounterDao {
	
	/**根据用户名查询
	 * @param userName
	 * @return
	 */
	public boolean info(String  userName);
	/**
	 * 修改用户信息
	 * @return
	 */
	public boolean update(Counter counter);
	/**
	 * 修改密码
	 * @return
	 */
	public boolean updatePwd(String userName,String passWord,String newpassWord);
	
	/**
	 * 插入一条用户信息
	 * @return
	 */
	public boolean saveCounter(Counter counter);
	/**
	 * 验证登陆信息
	 * @return
	 */
	public boolean canlogin(Admin admin);
}
