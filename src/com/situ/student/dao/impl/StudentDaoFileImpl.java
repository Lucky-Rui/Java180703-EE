package com.situ.student.dao.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;

/**
 * 
 * 用IO流文件的方式实现数据的增删改查
 */
public class StudentDaoFileImpl implements IStudentDao{

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudent(Student student) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> pageList(int offset, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAll(String[] selectIds) {
		// TODO Auto-generated method stub
		return 0;
	}

}
