package com.situ.day033;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet1
 */
public class CookieServlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("goods", "IPhoneX");
		Cookie cookie2 = new Cookie("name", "zhangsan");
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
	}
}
