package com.situ.student.service;

import com.situ.student.entity.User;

public interface IUserService {
	/**
	 * 登陆时查询账号密码是否正确
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name, String password);

	/**
	 * 注册时检查重名
	 * 
	 * @param name
	 * @return
	 */
	boolean checkName(String name);

	/**
	 * 注册时添加用户的账号与密码
	 * @param name
	 * @param password
	 * @return
	 */
	boolean register(User user);
}
