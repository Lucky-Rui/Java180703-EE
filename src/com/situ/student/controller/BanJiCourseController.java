package com.situ.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.BanJi;
import com.situ.student.entity.Course;
import com.situ.student.util.JDBCUtil;
import com.situ.student.util.ModelConvertUtil;

import net.sf.json.JSONArray;

public class BanJiCourseController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		switch (method) {
		case "banjicourseList":
			banjicourseList(req, resp);
			break;
		case "selectBanJi":
			selectBanJi(req, resp);
			break;
		case "selectCourse":
			selectCourse(req, resp);
			break;
		default:
			break;
		}
	}

	/**
	 * 列出所有班级学习的所有课程名称
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void banjicourseList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT b.id AS b_id,b.name AS b_name,c.id AS c_id,c.name AS c_name,c.credit AS c_credit FROM banji AS b INNER JOIN banji_course AS bc ON b.id=bc.banji_id INNER JOIN course AS c ON bc.course_id=c.id ORDER BY b.id";
			// 预编译sql
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			list = ModelConvertUtil.convertList(resultSet);
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("/banjicourse_list.jsp").forward(req, resp);
	}

	/**
	 * 选择课程时，将班级里没有的显示出来
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void selectCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String banjiId = req.getParameter("banjiId");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Course> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM course";
			// 预编译sql
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Integer credit = resultSet.getInt("credit");
				Course course = new Course(id, name, credit);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		for (Course course : list) {
			System.out.println(course);
		}

		JSONArray jsonArray = JSONArray.fromObject(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(jsonArray.toString());

	}

	/**
	 * 选择班级时，将班级列表展示出来
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */

	private void selectBanJi(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<BanJi> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM banji";
			// 预编译sql
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				BanJi banji = new BanJi(id, name);
				list.add(banji);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}

		for (BanJi banji : list) {
			System.out.println(banji);
		}

		JSONArray jsonArray = JSONArray.fromObject(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(jsonArray.toString());

	}
}
