package com.situ.student.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;

/**
 * 
 * 用内存的方式实现数据的增删改查
 */
public class StudentDaoMemoryImpl implements IStudentDao {
	private List<Student> list = new ArrayList<>();
	/**
	 * 插入学生信息
	 */
	@Override
	public int insert(Student student) {
		return 0;
	}
	/**
	 * 列出所有学生信息
	 */
	@Override
	public List<Student> list() {
		Student student1 = new Student(1, "张三1", 20, "男");
		Student student2 = new Student(2, "张三2", 20, "男");
		Student student3 = new Student(3, "张三3", 20, "男");
		Student student4 = new Student(4, "张三4", 20, "男");
		Student student5 = new Student(5, "张三5", 20, "男");
		Student student6 = new Student(6, "张三6", 20, "男");
		Student student7 = new Student(7, "张三7", 20, "男");
		Student student8 = new Student(8, "张三8", 20, "男");
		Student student9 = new Student(9, "张三9", 20, "男");
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		list.add(student6);
		list.add(student7);
		list.add(student8);
		list.add(student9);
		return list;
	}
/**
 * 通过id删除学生信息
 */
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
/**
 * 通过名字查找学生信息
 */
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
