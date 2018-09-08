package com.situ.student.service.impl;

import com.situ.student.dao.IUserDao;
import com.situ.student.dao.impl.UserDaoImpl;
import com.situ.student.entity.User;
import com.situ.student.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User login(String name, String password) {
		return userDao.findLogin(name, password);
	}

	@Override
	public boolean checkName(String name) {
		int count = userDao.findCountByName(name);
		return count > 0 ? true : false;
	}

	@Override
	public boolean register(User user) {
		int count = userDao.insert(user);
		return count == 1 ? true : false;
	}

}
