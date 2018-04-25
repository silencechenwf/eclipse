package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.chinasofti.bean.Employee;

public class MeetingparticipantsDao {
	private String sql;
	private Connection conn;
	private PreparedStatement prepareStatement;
	private ResultSet rs;
	private Statement statement;

	public boolean insertMeetingparticipants(String meetingIdSql, String empIdSql) {
		boolean flag = false;
		conn = ConnectionFactory.getConnection();
		sql = "INSERT INTO MEETINGPARTICIPANTS (MEETINGID,EMPLOYEEID) VALUES (" + meetingIdSql + "," + empIdSql + ")";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			flag = true;
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

	public ArrayList<Employee> selectEmpByMeetingId(String meetingIdSql) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		sql = "select * from (select e.employeename,e.phone,e.email,m.meetingid from MEETINGPARTICIPANTS m,employee e where e.employeeid=m.employeeid)s where s.meetingid="
				+ meetingIdSql;
		conn = ConnectionFactory.getConnection();
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString(1));
				emp.setPhone(rs.getString(2));
				emp.setEmail(rs.getString(3));
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
