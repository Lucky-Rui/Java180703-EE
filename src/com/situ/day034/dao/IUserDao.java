package com.situ.day034.dao;

import java.util.List;

import com.situ.day034.entity.User;

public interface IUserDao {
	/**
	 * 登陆（用户名和密码）
	 * @param name
	 * @param password
	 * @return 查到的用户
	 */
	User findLogin(String name,String password);
}
