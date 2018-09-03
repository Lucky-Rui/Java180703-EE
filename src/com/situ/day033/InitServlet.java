package com.situ.day033;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author WANGRUI
 *
 */
public class InitServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("InitServlet.service()");
	}

	public InitServlet() {
		System.out.println("InitServlet.InitServlet()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("InitServlet.init()");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = config.getServletContext();
		servletContext.setAttribute("count", 0);
	}
}
