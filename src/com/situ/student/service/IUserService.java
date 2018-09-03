package com.situ.student.service;

import org.apache.catalina.deploy.LoginConfig;

import com.situ.student.entity.User;

public interface IUserService {
	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name,String password);
}
