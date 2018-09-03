package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.situ.student.dao.IUserDao;
import com.situ.student.entity.User;
import com.situ.student.util.JDBCUtil;

public class UserDaoImpl implements IUserDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public User findLogin(String name, String password) {
		User user = null;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from user where name = ? and password = ?";
			// String sql = "SELECT id,name,age,gender FROM student";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			// 查询(没有改变表里面数据)：select executeQuery() 返回结果集：ResultSet
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String fname = resultSet.getString("name");
				String fpassword = resultSet.getString("password");
				user = new User(fname, fpassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return user;
	}

}
