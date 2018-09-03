package com.situ.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、得到浏览器学生信息
		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		Student student = new Student(name, age, gender);
		//2、调用servlet处理
		boolean result = studentService.insert(student);
		System.out.println(result ? "成功" : "失败");
		//重定向到列表界面
		resp.sendRedirect("/Java180703(Java EE)/student_list.jsp");
	}
}
