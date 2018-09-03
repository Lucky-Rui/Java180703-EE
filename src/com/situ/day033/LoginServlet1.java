package com.situ.day033;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet1 extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// String maxOnLine = config.getInitParameter("maxOnLine");
		// String servletName = config.getServletName();
		// ServletContext servletContext = config.getServletContext();
		// System.out.println("maxOnLine: " + maxOnLine);
		// System.out.println("servletName: " + servletName);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// // 此ServletConfig就是init传过来那个
		// ServletConfig servletConfig = getServletConfig();
		// String maxOnLine = servletConfig.getInitParameter("maxOnLine");
		// System.out.println("maxOnLine: " + maxOnLine);
		// PrintWriter writer = resp.getWriter();
		// writer.println("maxOnLine: " + maxOnLine);
		// writer.close();

		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("name", "zhangsan");
		// servletContext.getRealPath(path);返回资源文件的绝对路径
		// 获取路径a.txt b.txt c.txt d.txt
		// a.txt
		// Servlet是运行在服务器端的代码，"/"代表的是部署到tomcat上Java1807Web这个项目根目录
		String aPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");
		System.out.println("aPath: " + aPath);
		// b.txt
		String bPath = servletContext.getRealPath("/b.txt");
		System.out.println("bPath: " + bPath);
		// c.txt
		String cPath = servletContext.getRealPath("/WEB-INF/c.txt");
		System.out.println("cPath: " + cPath);
		// d.txt 没有部署到tomcat上，所以无法获取路径

		// servletContext.getResourceAsStream返回资源文件的输入流
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String url = properties.getProperty("url");
		System.out.println("url: " + url);
	}
}