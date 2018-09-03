package com.situ.weekend07.banji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.situ.weekend07.banji.dao.IBanJiDao;
import com.situ.weekend07.banji.entity.BanJi;
import com.situ.weekend07.banji.util.JDBCUtil;

public class BanJiDaoJdbcImpl implements IBanJiDao {
	private List<BanJi> list = new ArrayList<>();
	private final String SQL_NAME = "BanJi";
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Override
	public List<BanJi> list() {
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from " + SQL_NAME + ";";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			List<BanJi> CopyList = new ArrayList<>();
			while (resultSet.next()) {
				Integer id = null;
				String name = null;
				id = resultSet.getInt("classId");
				name = resultSet.getString("className");
				BanJi banJi = new BanJi(id, name);
				CopyList.add(banJi);
			}
			list = CopyList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public int insert(BanJi banJi) {
		String name = banJi.getClassName();
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = ("insert into BanJi(className) values (?);");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			System.out.println(preparedStatement);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, null);
		}
		return count;
	}

	@Override
	public int deleteById(Integer id) {
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = ("DELETE from BanJi where classId = ?;");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, null);
		}
		return count;
	}

	@Override
	public int update(BanJi banJi) {
		int id = banJi.getClassId();
		String name = banJi.getClassName();
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = ("UPDATE BanJi set className = ? WHERE classId = ?;");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, null);
		}
		return count;
	}

	@Override
	public List<BanJi> searchByName(String name) {
		try {
			connection = JDBCUtil.getConnection();
			String sql = ("SELECT * from BanJi WHERE className like ?;");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");
			resultSet = preparedStatement.executeQuery();
			List<BanJi> CopyList = new ArrayList<>();
			while (resultSet.next()) {
				Integer id = null;
				String className = null;
				id = resultSet.getInt("id");
				className = resultSet.getString("name");
				BanJi banJi = new BanJi(id, className);
				CopyList.add(banJi);
			}
			list = CopyList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, null);
		}
		return list;
	}

	@Override
	public BanJi SearchById(Integer id) {
		BanJi banJi = new BanJi();
		try {
			connection = JDBCUtil.getConnection();
			String sql = ("SELECT * from BanJi WHERE classId = ?;");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer classId = null;
				String className = null;
				classId = resultSet.getInt("classId");
				className = resultSet.getString("className");
				banJi = new BanJi(classId, className);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, resultSet);
		}
		return banJi;
	}

	@Override
	public int getTotalCount() {
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select count(classId) from " + SQL_NAME + ";";
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(statement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);// 代表第一列
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, resultSet);
		}
		return count;
	}

	@Override
	public List<BanJi> pageList(int offset, int pageSize) {
		List<BanJi> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from " + SQL_NAME + " limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, pageSize);
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = null;
				String name = null;
				id = resultSet.getInt("classId");
				name = resultSet.getString("className");
				BanJi banJi = new BanJi(id, name);
				list.add(banJi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public int deleteAll(String[] selectIds) {
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = ("DELETE from BanJi where classId = ?;");
			preparedStatement = connection.prepareStatement(sql);
			for (String id : selectIds) {
				preparedStatement.setInt(1, Integer.parseInt(id));
				preparedStatement.addBatch();
			}
			int[] counts = preparedStatement.executeBatch();
			count = counts.length;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement, null);
		}
		return count;
	}
}
