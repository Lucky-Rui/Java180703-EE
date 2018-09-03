package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.User;

public interface IUserDao {
	/**
	 * 登陆（用户名和密码）
	 * @param name
	 * @param password
	 * @return 查到的用户
	 */
	User findLogin(String name,String password);
}
