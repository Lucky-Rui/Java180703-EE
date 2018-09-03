package com.situ.day034.service;

import org.apache.catalina.deploy.LoginConfig;

import com.situ.day034.entity.User;

public interface IUserService {
	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name,String password);
}
