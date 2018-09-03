package com.situ.day030;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//service() 方法是执行实际任务的主要方法。
		System.out.println("LifeServlet.service()");
	}

	public LifeServlet() {
		System.out.println("LifeServlet.LifeServlet()");
	}

	@Override
	public void init() throws ServletException {
		//init 方法被设计成只调用一次。它在第一次创建 Servlet 时被调用
		System.out.println("LifeServlet.init()");
	}

	@Override
	public void destroy() {
		//终止化代码
		System.out.println("LifeServlet.destroy()");
	}
}
