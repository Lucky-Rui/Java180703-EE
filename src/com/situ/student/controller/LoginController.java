package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.entity.User;
import com.situ.student.service.IUserService;
import com.situ.student.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginController extends HttpServlet {
	private IUserService uerService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		switch (method) {
		case "login":
			login(req, resp);
			break;
		case "logout":
			logout(req, resp);
			break;
		default:
			break;
		}
	}

	/**
	 * 注销操作
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//先得到servletContext对象
		ServletContext servletContext = getServletContext();
		//获取列表集合
		List<User> onLineUserList = (List<User>) servletContext.getAttribute("onLineUserList");
		if (user != null) {
			onLineUserList.remove(user);
			// 销毁Session
			session.invalidate();
			// 重定向到登陆界面
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * 登陆操作
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1、获取验证码
		String checkCode = req.getParameter("checkCode");
		String checkCodeSession = (String) req.getSession().getAttribute("checkCodeSession");
		if (null == checkCode || "".equals(checkCode) || !checkCode.equalsIgnoreCase(checkCodeSession)) {
			// 验证码输入错误，重定向到该界面
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		// 2、获取输入的账号密码
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		// 3、业务处理
		User user = uerService.login(name, password);
		// 转发或者重定向到页面
		if (user != null) {// 登陆成功
			// 创建session
			HttpSession session = req.getSession();
			// 将数据保存到域对象session
			session.setAttribute("user", user);
			//先得到servletContext对象
			ServletContext servletContext = getServletContext();
			//获取列表集合
			List<User> onLineUserList = (List<User>) servletContext.getAttribute("onLineUserList");
			if (onLineUserList != null) {
				//添加当前登录的user
				onLineUserList.add(user);
			}
			// 重定向到学生列表
			resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
		} else {
			// 登陆失败
			resp.sendRedirect(req.getContextPath() + "/fail.html");
		}
	}
}
