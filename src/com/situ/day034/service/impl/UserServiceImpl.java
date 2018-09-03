package com.situ.day034.service.impl;

import java.util.List;

import com.situ.day034.dao.IUserDao;
import com.situ.day034.dao.impl.UserDaoJdbcImpl;
import com.situ.day034.entity.User;
import com.situ.day034.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoJdbcImpl();
	@Override
	public User login(String name, String password) {
		return userDao.findLogin(name, password);
	}

}
