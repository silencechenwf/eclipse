package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.chinasofti.bean.Department;

public class DepartmentDao {
	private Connection conn = ConnectionFactory.getConnection();
	private String sql;
	private Statement statement;
	private PreparedStatement prepareStatement;
	private ResultSet rs;
	public ArrayList<Department> selectDepartmentName() {
		ArrayList<Department> list = new ArrayList<Department>();
		sql = "SELECT * FROM DEPARTMENT";
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Department dept = new Department(rs.getInt("DEPARTMENTID"), rs.getString("DEPARTMENTNAME"));
				list.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
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
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public boolean deleteDepartment(String delName) {
		boolean flag = false;
		sql = "DELETE FROM DEPARTMENT WHERE DEPARTMENTNAME=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, delName);
			prepareStatement.executeUpdate();
			if (prepareStatement != null) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public boolean insertDepartment(String addName) {
		boolean flag = false;
		sql = "INSERT INTO DEPARTMENT VALUES(DEPARTMENTID_SEQ.NEXTVAL,?)";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, addName);
			prepareStatement.executeUpdate();
			if (prepareStatement != null) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}
}
