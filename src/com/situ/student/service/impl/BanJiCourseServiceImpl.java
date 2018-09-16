package com.situ.student.service.impl;

import com.situ.student.dao.IBanJiCourseDao;
import com.situ.student.dao.impl.BanJiCourseDaoImpl;
import com.situ.student.service.IBanJiCourseService;

public class BanJiCourseServiceImpl implements IBanJiCourseService{
	private IBanJiCourseDao banJiCourseDao = new BanJiCourseDaoImpl();
	
}
