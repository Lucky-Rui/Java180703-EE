package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IBanJiDao;
import com.situ.student.entity.BanJi;
import com.situ.student.util.JDBCUtil;

public class BanJiDaoImpl implements IBanJiDao {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private List<BanJi> list = null;

	@Override
	public List<BanJi> list() {
		List<BanJi> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "select * from  banji ;";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
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
	public int insert(BanJi banJi) {
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "insert into banji(name) values ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banJi.getName());
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
			String sql = "DELETE from banji where id = ?;";
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
		int count = 0;
		try {
			connection = JDBCUtil.getConnection();
			String sql = "UPDATE banji set name = ? WHERE id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banJi.getName());
			preparedStatement.setInt(2, banJi.getId());
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
		List<BanJi> list = new ArrayList<>();
		try {
			connection = JDBCUtil.getConnection();
			String sql = "SELECT * from BanJi WHERE name like ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name1 = resultSet.getString("name");
				BanJi banJi = new BanJi(id, name1);
				list.add(banJi);
			}
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
			String sql = ("SELECT * from BanJi WHERE id = ?;");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id1 = resultSet.getInt("id");
				String name = resultSet.getString("name");
				banJi = new BanJi(id1, name);
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
			String sql = "select count(id) from banji;";
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
			String sql = "select id,name from banji limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, pageSize);
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
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
			String sql = "DELETE from banji where id = ?;";
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
