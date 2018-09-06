package com.situ.day038.省市区三级联动.ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.day038.省市区三级联动.entity.Area;
import com.situ.day038.省市区三级联动.entity.City;
import com.situ.day038.省市区三级联动.entity.Province;
import com.situ.student.util.JDBCUtil;

import net.sf.json.JSONArray;

public class SelectAreaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		switch (method) {
		case "selectProvince":
			selectProvince(req, resp);
			break;
		case "selectCity":
			selectCity(req, resp);
			break;
		case "selectArea":
			selectArea(req, resp);
			break;
		default:
			break;
		}
	}

	private void selectProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Province> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT id,province,sort FROM tm_province";
			// 预编译sql
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String province = resultSet.getString("province");
				Integer sort = resultSet.getInt("sort");
				Province province2 = new Province(id, province, sort);
				list.add(province2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		
		for (Province province : list) {
			System.out.println(province);
		}
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(jsonArray.toString());
	}
	
	private void selectCity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String provinceId = req.getParameter("provinceId");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<City> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT id,city FROM tm_city where province_id=?";
			// 预编译sql
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(provinceId));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String city = resultSet.getString("city");
				City city2 = new City(id, city);
				list.add(city2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		
		for (City city : list) {
			System.out.println(city);
		}
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(jsonArray.toString());
	}
	
	private void selectArea(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String cityId = req.getParameter("cityId");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Area> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT id,area FROM tm_area where city_id=?";
			// 预编译sql
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(cityId));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String area = resultSet.getString("area");
				Area area2 = new Area(id, area);
				list.add(area2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		
		for (Area area : list) {
			System.out.println(area);
		}
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(jsonArray.toString());
	}
}
