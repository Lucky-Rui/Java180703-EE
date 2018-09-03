package com.situ.day029;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();//java.util.Date
		SimpleDateFormat simpleDateFormat 
			= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String nowDate = simpleDateFormat.format(date);
		
		//将信息返回给浏览器
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<p>" + nowDate + "</p>");
		printWriter.close();
	}
}
