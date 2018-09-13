package com.situ.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.dao.IBanJiDao;
import com.situ.student.entity.BanJi;
import com.situ.student.entity.PageBean;
import com.situ.student.entity.Student;
import com.situ.student.service.IBanJiService;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.BanJiServiceImpl;
import com.situ.student.service.impl.StudentServiceImpl;

public class StudentController extends HttpServlet {
	private IStudentService studentService = new StudentServiceImpl();
	private IBanJiService banjiService = new BanJiServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:8080/Java180703(JavaEE)/student?method=list
		// System.out.println(req.getContextPath());// /Java180703(JavaEE)
		// System.out.println(req.getServletPath());// /student
		// System.out.println(req.getRequestURI());//
		// /Java180703(Java%20EE)/student
		// System.out.println(req.getRequestURL());//
		// http://localhost:8080/Java180703(Java%20EE)/student

		// 判断用户有没有登陆，利用session，没有登陆就提示登陆
		/*
		 * HttpSession session = req.getSession(); User user = (User)
		 * session.getAttribute("user"); if (user == null) { // 用户没有登陆，重定向到登陆界面
		 * resp.sendRedirect(req.getContextPath() + "/login.jsp"); return; }
		 */

		// req.setCharacterEncoding("UTF-8");
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
		case "getAddBanJiPage":
			getAddBanJiPage(req, resp);
			break;
		default:
			break;
		}

	}

	/**
	 * 通过访问这个Servlet，查出所有班级信息，放到域对象中，转发到student_add.jsp
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getAddBanJiPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BanJi> list = banjiService.list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/student_add.jsp").forward(req, resp);
	}

	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] selectIds = req.getParameterValues("selectIds");
		System.out.println(Arrays.toString(selectIds));
		studentService.deleteAll(selectIds);
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
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
			pageSizeStr = "20";
		}
		int pageSize = Integer.parseInt(pageSizeStr);
		// 2、封装成PageBean，调用Service层业务逻辑
		PageBean<Student> pageBean = studentService.getPageBean(pageNo, pageSize);
		System.out.println(pageBean);
		// 3、放入数据，转发
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1、得到浏览器传递过来的参数信息
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		Integer banjiId = Integer.parseInt(req.getParameter("banjiId"));
		Student student = new Student(id, name, age, gender,banjiId);
		// 2、调用service处理
		boolean result = studentService.updateStudent(student);
		System.out.println(result ? "成功" : "失败");
		// 3、重定向到列表界面
		// resp.sendRedirect(req.getContextPath() + "/student?method=list");
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
	}

	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 根据id查找出要修改的学生对象
		Integer id = Integer.parseInt(req.getParameter("id"));
		Student student = studentService.findById(id);
		List<BanJi> list = banjiService.list();
		// 转发到student_update.jsp页面
		req.setAttribute("list", list);
		req.setAttribute("student", student);
		req.getRequestDispatcher("/student_update.jsp").forward(req, resp);
	}

	public void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1、得到浏览器学生信息
		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		Integer banjiId = Integer.parseInt(req.getParameter("banjiId"));
		Student student = new Student(name, age, gender, banjiId);
		// 2、业务处理
		boolean result = studentService.insert(student);
		System.out.println(result ? "成功" : "失败");
		// 重定向到列表界面
		// resp.sendRedirect(req.getContextPath() + "/student?method=list");
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
	}

	public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 得到第几页
		Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));
		//System.out.println(pageNo);
		// 得到页面上选中的Id
		Integer id = Integer.parseInt(req.getParameter("id"));
		// 删除处理
		studentService.deleteById(id);
		// 重定向到列表界面
		// resp.sendRedirect(req.getContextPath() + "/student?method=list");
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList&pageNo=" + pageNo + "&pageSize=20");
	}

	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = new ArrayList<>();
		// 1、得到浏览器传递过来的参数信息
		String name = req.getParameter("name");
		if (name == null || name.equals("")) {// 查找所有
			list = studentService.list();
		} else {// 根据名字模糊查找
			// 模糊查找
			list = studentService.findByName(name);
		}

		for (Student student : list) {
			System.out.println(student);
		}
		// 将list放到req里面
		req.setAttribute("list", list);
		// 转发到student_list.jsp页面进行展示
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
	}
}
