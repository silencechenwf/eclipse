package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CounterDao {
	private Connection conn = ConnectionFactory.getConnection();
	private String sql;
	private Statement statement;
	private PreparedStatement prepareStatement;

	public boolean insert() {
		boolean flag=false;
		sql = "INSERT INTO COUNTER VALUES (0)";
		try {
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			if (statement!=null) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public boolean upadate(Integer counts) {
		boolean flag=false;
		sql = "UPDATE COUNTER SET VISITCOUNT=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, counts);
			prepareStatement.executeUpdate();
			if (prepareStatement!=null) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public Integer select() {
		sql="SELECT * FROM COUNTER";
		try {
			statement=conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Integer i = rs.getInt(1);
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
