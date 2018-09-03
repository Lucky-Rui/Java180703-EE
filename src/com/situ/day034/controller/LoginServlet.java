package com.situ.day034.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.day034.entity.User;
import com.situ.day034.service.IUserService;
import com.situ.day034.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private IUserService uerService =  new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取参数
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		// 业务处理
		User user = uerService.login(name, password);
		// 转发或者重定向到页面
		if (user != null) {
			//登陆成功
			//创建session
			HttpSession session = req.getSession();
			//将数据保存到域对象
			session.setAttribute("user", user);
			//重定向到学生列表
			resp.sendRedirect(req.getContextPath()+"/student?method=pageList");
		} else {
			// 登陆失败
			resp.sendRedirect(req.getContextPath()+"/fail.html");
		}
	}
}
