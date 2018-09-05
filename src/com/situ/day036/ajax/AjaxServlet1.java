package com.situ.day036.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxServlet1.doGet()");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println("name: " + name);
		System.out.println("age: " + age);

		resp.setContentType("text/html;charset=utf-8");
		// {"name":"李四", "age": 21}
		resp.getWriter().write("{\"name\":\"李四Get\", \"age\": 21}");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxServlet1.doPost()");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println("name: " + name);
		System.out.println("age: " + age);

		resp.setContentType("text/html;charset=utf-8");
		// {"name":"李四", "age": 21}
		resp.getWriter().write("{\"name\":\"李四Post\", \"age\": 21}");
	}
}
