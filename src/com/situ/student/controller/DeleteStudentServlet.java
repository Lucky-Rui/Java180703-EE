package com.situ.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet{
	private IStudentService studentService = new StudentServiceImpl();
	
//	public boolean deleteById(Integer id) {
//		return studentService.deleteById(id);
//	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//得到页面上选中的Id
		Integer id = Integer.parseInt(req.getParameter("id"));
		//删除处理
		studentService.deleteById(id);
		//重定向到列表界面
		resp.sendRedirect("/Java180703(Java EE)/student_list.jsp");
		
		//转发到findStudent界面
		//req.getRequestDispatcher("findStudent").forward(req, resp);
	}
}
