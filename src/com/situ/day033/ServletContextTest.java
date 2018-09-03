package com.situ.day033;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post提交来的中文(浏览器到服务器)
		req.setCharacterEncoding("utf-8");
		// 服务器到浏览器乱码问题
		resp.setContentType("text/html;charset=utf-8");

		ServletContext servletContext = getServletContext();
		Integer count = (Integer) servletContext.getAttribute("count");
		if (count == null) {
			servletContext.setAttribute("count", 1);
		} else {
			servletContext.setAttribute("count", Integer.parseInt(count.toString()) + 1);
		}
		System.out.println("总浏览量为：" + servletContext.getAttribute("count"));
		PrintWriter writer = resp.getWriter();
		writer.println("总浏览量为" + servletContext.getAttribute("count"));
		writer.close();
	}
}
