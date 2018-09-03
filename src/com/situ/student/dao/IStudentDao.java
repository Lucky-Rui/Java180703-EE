package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Student;

public interface IStudentDao {
	/**
	 * 插入学生信息
	 * 
	 * @param student
	 * @return
	 */
	int insert(Student student);

	/**
	 * 返回所有学生的集合
	 * 
	 * @return
	 */
	List<Student> list(); // findAll()

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return 删除成功返回true 失败返回false
	 */
	int deleteById(Integer id);

	/**
	 * 根据名字来查找
	 * 
	 * @param name
	 * @return
	 */
	List<Student> findByName(String name);// findByName

	/**
	 * 修改学生
	 * 
	 * @param student
	 */
	int updateStudent(Student student);

	/**
	 * 修改时用于查找学生信息来展示
	 * 
	 * @param id
	 * @return
	 */
	Student findById(Integer id);

	/**
	 * 返回一共有多少条记录
	 * 
	 * @return
	 */
	int getTotalCount();

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	List<Student> pageList(int offset, int pageSize);

	/**
	 * 
	 * @param selectIds
	 * @return
	 */
	int deleteAll(String[] selectIds);

}