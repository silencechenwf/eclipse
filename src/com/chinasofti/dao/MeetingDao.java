package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chinasofti.bean.Meeting;

public class MeetingDao {
	private String sql;
	private Connection conn;
	private PreparedStatement prepareStatement;
	private Statement statement;
	private ResultSet rs;

	public Integer reserveMeeting(String meetingName, String roomId, String reservationistId,
			String numberOfParticipants, String startTime, String endTime, String description) {
		Integer meetingId = null;
		sql = "INSERT INTO MEETING (MEETINGID,MEETINGNAME,ROOMID,RESERVATIONSTID,NUMBEROFPARTCIPANTS,STARTTIME,ENDTIME,RESERVATIONTIME,DESCRIPTION,STATUS) "
				+ "VALUES( MEETINGID_SEQ.NEXTVAL" + meetingName + roomId + reservationistId + numberOfParticipants
				+ startTime + endTime + ",sysdate" + description + ",0)";
		conn = ConnectionFactory.getConnection();
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			sql = "select MEETINGID_SEQ.currval from dual";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				meetingId = rs.getInt(1);
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
		return meetingId;
	}

	public ArrayList<Meeting> selectMeetingByEmpId(String empIdSql) {
		ArrayList<Meeting> list = new ArrayList<>();
		sql = "select r.roomname,s.meetingname,s.starttime,s.endtime,s.RESERVATIONTIME,s.DESCRIPTION,s.meetingid,s.status from meetingroom r,(select n.meetingid,n.roomid,n.DESCRIPTION,n.meetingname,n.starttime,n.endtime,n.RESERVATIONTIME,n.status from meeting n,(select m.meetingid from MEETINGPARTICIPANTS m where m.employeeid="
				+ empIdSql + ")e where n.meetingid(+)=e.meetingid)s where s.roomid=r.roomid";
		conn = ConnectionFactory.getConnection();
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Meeting mt = new Meeting();
				mt.setRoomName(rs.getString(1));
				mt.setMeetingName(rs.getString(2));
				mt.setStartTime(rs.getDate(3));
				mt.setEndTime(rs.getDate(4));
				mt.setReservationTime(rs.getDate(5));
				mt.setDescription(rs.getString(6));
				mt.setMeetingId(rs.getInt(7));
				mt.setStatus(rs.getString(8));
				list.add(mt);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public Meeting selectMyBookingById(String meetingIdSql) {
		Meeting meeting = new Meeting();
		sql = "select * from meeting where meetingid=" + meetingIdSql;
		conn = ConnectionFactory.getConnection();
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				meeting.setMeetingName(rs.getString("MEETINGNAME"));
				meeting.setNumberOfParticipants(rs.getInt("NUMBEROFPARTCIPANTS"));
				meeting.setStartTime(rs.getDate("STARTTIME"));
				meeting.setEndTime(rs.getDate("ENDTIME"));
				meeting.setDescription(rs.getString("DESCRIPTION"));
			}
			return meeting;
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
	public boolean updateStatusOfMeeting(String statusSql){
		sql="update meeting set ";
		
		
		return false;
	}
}
