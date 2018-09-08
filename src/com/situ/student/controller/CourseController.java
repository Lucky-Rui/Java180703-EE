package com.situ.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Course;
import com.situ.student.entity.PageBean;
import com.situ.student.service.ICourseService;
import com.situ.student.service.impl.CourseServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CourseController
 */
public class CourseController extends HttpServlet {
	private ICourseService courseService = new  CourseServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");

		String method = req.getParameter("method");
		switch (method) {
		case "list":
			list(req, resp);
			break;
		case "pageList":
			pageList(req, resp);
			break;
		case "deleteById":
			deleteById(req, resp);
			break;
		case "insert":
			insert(req, resp);
			break;
		case "toUpdate":
			toUpdate(req, resp);
			break;
		case "update":
			update(req, resp);
			break;
		case "deleteAll":
			deleteAll(req, resp);
			break;
		case "checkName":
			checkName(req, resp);
			break;
		default:
			break;
		}
	}

	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		boolean isExist = courseService.checkName(name);
		// {"isExist":isExist}
		Map<String, Object> map = new HashMap<>();
		map.put("isExist", isExist);
		JSONObject jsonObject = JSONObject.fromObject(map);
		resp.setContentType("text/html;charset=utf-8");
		// resp.getWriter().write("{\"isExist\":"+isExist+"}");
		resp.getWriter().write(jsonObject.toString());
	}

	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] selectIds = req.getParameterValues("selectIds");
		System.out.println(Arrays.toString(selectIds));
		courseService.deleteAll(selectIds);
		resp.sendRedirect(req.getContextPath() + "/course?method=pageList");

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1、得到浏览器传递过来的参数信息
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Integer credit = Integer.parseInt(req.getParameter("credit"));
		Course course = new Course(id, name, credit);
		// 2、调用service处理
		boolean result = courseService.updateCourse(course);
		System.out.println(result ? "成功" : "失败");
		// 3、重定向到列表界面
		resp.sendRedirect(req.getContextPath() + "/course?method=pageList");

	}

	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 根据id查找出要修改的course对象
		Integer id = Integer.parseInt(req.getParameter("id"));
		Course course = courseService.findById(id);
		// 转发到course_update.jsp页面
		req.setAttribute("course", course);
		req.getRequestDispatcher("/course_update.jsp").forward(req, resp);

	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1、得到浏览器course信息
		String name = req.getParameter("name");
		Integer credit = Integer.parseInt(req.getParameter("credit"));
		Course course = new Course(name,credit);
		// 2、调用servlet处理
		boolean result = courseService.insert(course);
		System.out.println(result ? "成功" : "失败");
		// 重定向到列表界面
		resp.sendRedirect(req.getContextPath() + "/course?method=pageList");

	}

	private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 得到第几页
		Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));
		System.out.println(pageNo);
		// 得到页面上选中的Id
		Integer id = Integer.parseInt(req.getParameter("id"));
		// 删除处理
		courseService.deleteById(id);
		// 重定向到列表界面
		resp.sendRedirect(req.getContextPath() + "/course?method=pageList&pageNo=" + pageNo + "&pageSize=10");

	}

	private void pageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接收请求参数
		String pageNoStr = req.getParameter("pageNo");
		if (pageNoStr == null || pageNoStr.equals("")) {
			pageNoStr = "1";
		}
		int pageNo = Integer.parseInt(pageNoStr);
		String pageSizeStr = req.getParameter("pageSize");
		if (pageSizeStr == null || pageSizeStr.equals("")) {
			pageSizeStr = "10";
		}
		int pageSize = Integer.parseInt(pageSizeStr);
		// 2、封装成PageBean，调用Service层业务逻辑
		PageBean<Course> pageBean = courseService.getPageBean(pageNo, pageSize);
		System.out.println(pageBean);
		// 3、放入数据，转发
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("course_list.jsp").forward(req, resp);

	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Course> list = new ArrayList<>();
		// 1、得到浏览器传递过来的参数信息
		String name = req.getParameter("name");
		if (name == null || name.equals("")) {// 查找所有
			list = courseService.list();
		} else {// 根据名字模糊查找
			// 模糊查找
			list = courseService.findByName(name);
		}
		for (Course	course : list) {
			System.out.println(course);
		}

		// 将list放到req里面
		req.setAttribute("list", list);
		// 转发到course_list.jsp页面进行展示
		req.getRequestDispatcher("/course_list.jsp").forward(req, resp);
	}
}
