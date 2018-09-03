package com.situ.day033;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 你上次登陆的时间是：
 * @author WANGRUI
 *
 */
public class LastAccessTimeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、记录当前访问时间，设置到Cookie上
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = simpleDateFormat.format(date);
		Cookie cookie = new Cookie("lastAccessTime", time);
		resp.addCookie(cookie);

		// 2、获得Cookie，显示到页面
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals("lastAccessTime")) {
					lastAccessTime = coo.getValue();
				}
			}
		}

		// 在页面显示
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		if (lastAccessTime == null) {
			writer.println("您是第一次访问");
		} else {
			writer.println("您上次访问的时间：" + lastAccessTime);
		}
	}
}
