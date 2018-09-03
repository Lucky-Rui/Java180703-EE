package com.situ.weekend07.banji.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.weekend07.banji.entity.BanJi;
import com.situ.weekend07.banji.entity.BanJi_PageBean;
import com.situ.weekend07.banji.service.IBanJiService;
import com.situ.weekend07.banji.service.impl.BanJiServiceImpl;

public class BanJiServlet extends HttpServlet {
	private IBanJiService banjiService = new BanJiServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");

		List<BanJi> list = banjiService.list();
		String method = req.getParameter("method");
		switch (method) {
		case "list":
			list(req, resp);
			break;
		case "pageList":
			pageList(req, resp);
			break;
		case "insert":
			insert(req, resp);
			break;
		case "delById":
			delById(req, resp);
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
		default:
			break;
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BanJi> list;
		// 1、得到浏览器传递过来的参数信息
		String name = req.getParameter("name");
		if (name == null || name.equals("")) {// 查找所有
			list = banjiService.list();
		} else {// 根据名字模糊查找
			// 模糊查找
			list = banjiService.searchByName(name);
		}
		// 将list放到req里面
		req.setAttribute("list", list);
		// 转发到banji_list.jsp页面进行展示
		req.getRequestDispatcher("/banji_list.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1、得到浏览器传递过来的参数信息
		Integer id = Integer.parseInt(req.getParameter("id"));
		String className = req.getParameter("className");
		BanJi banJi = new BanJi(id, className);
		// 2、调用service处理
		boolean result = banjiService.update(banJi);
		// 3、重定向到列表界面
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}

	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 根据id查找出要修改的班级对象
		Integer id = Integer.parseInt(req.getParameter("id"));
		BanJi banJi = banjiService.SearchById(id);
		// 转发到banji_update.jsp页面
		req.setAttribute("banJi", banJi);
		req.getRequestDispatcher("/banji_update.jsp").forward(req, resp);
	}

	private void delById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		System.out.println(pageNo);
		// 1.获得id
		Integer id = Integer.parseInt(req.getParameter("id"));
		boolean result = banjiService.deleteById(id);
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList&pageNo=" + pageNo + "&pageSize=3");
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String className = req.getParameter("className");
		BanJi banJi = new BanJi(className);
		boolean insertResult = banjiService.insert(banJi);
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}

	private void pageList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、接收请求参数并附初始值：
		String pageNoStr = req.getParameter("pageNo");
		if (pageNoStr == null || pageNoStr.equals("")) {
			pageNoStr = "1";
		}
		int pageNo = Integer.parseInt(pageNoStr);

		String pageSizeStr = req.getParameter("pageSize");
		if (pageSizeStr == null || pageSizeStr.equals("")) {
			pageSizeStr = "5";
		}
		int pageSize = Integer.parseInt(pageSizeStr);
		// 2、封装成PageBean，调用Service层业务逻辑
		BanJi_PageBean pageBean = banjiService.getPageBean(pageNo, pageSize);
		System.out.println(pageBean);
		// 3、控制界面跳转
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/banji_list.jsp").forward(req, resp);
	}

	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] selectIds = req.getParameterValues("selectIds");
		System.out.println(Arrays.toString(selectIds));
		banjiService.deleteAll(selectIds);
		resp.sendRedirect(req.getContextPath() + "/banji?method=pageList");
	}

}
