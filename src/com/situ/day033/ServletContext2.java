package com.situ.day033;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;

public class ServletContext2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String name = (String) servletContext.getAttribute("name");
		List<Student> list = (List<Student>) servletContext.getAttribute("list");
		System.out.println("name: " + name);
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
