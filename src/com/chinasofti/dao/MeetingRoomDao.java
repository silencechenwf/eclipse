package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chinasofti.bean.MeetingRoom;

public class MeetingRoomDao {
	/*
	 * 查询所有 添加一个会议室 根据ID查询某一条记录 根据ID更新某一条记录 根据ID更新状态（后续使用）
	 */
	public ArrayList<MeetingRoom> selectAllMeetingRoom() {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM MEETINGROOM";
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setRoomId(rs.getInt("ROOMID"));
				meetingRoom.setRoomName(rs.getString("ROOMNAME"));
				meetingRoom.setRoomNum(rs.getInt("ROOMNUM"));
				meetingRoom.setStatus(rs.getString("STATUS"));
				meetingRoom.setCapacity(rs.getInt("CAPACITY"));
				meetingRoom.setDescription(rs.getString("DESCRIPTION"));
				list.add(meetingRoom);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			conn.prepareStatement(sql);
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
		return list;
	}

	public MeetingRoom searchMeetingRoom(Integer roomId) {
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement prepareStatement = null;
		String sql = "SELECT * FROM MEETINGROOM WHERE ROOMID=?";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, roomId);
			rs = prepareStatement.executeQuery();
			if (rs.next()) {
				MeetingRoom room = new MeetingRoom();
				room.setRoomId(rs.getInt("ROOMID"));
				room.setRoomNum(rs.getInt("ROOMNUM"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setCapacity(rs.getInt("CAPACITY"));
				room.setStatus(rs.getString("STATUS"));
				room.setDescription(rs.getString("DESCRIPTION"));
				return room;
			}
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
		return null;
	}
	public boolean updateMeetingRoom(String roomIdSql,String roomNumSql,String roomNameSql,String capacitySql,String statusSql,String descriptionSql){
		boolean flag=false;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement  statement=null;
		String sql="UPDATE MEETINGROOM SET ROOMNUM="+roomNumSql +",ROOMNAME='"+roomNameSql+ "',CAPACITY=" +capacitySql+", STATUS='"+statusSql+"', DESCRIPTION='"+descriptionSql+"' WHERE ROOMID="+roomIdSql;
		try {
			statement = conn.prepareStatement(sql);			
			statement.executeUpdate();
			if (statement!=null) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	public boolean insertMeetingRoom(String roomNumSql,String roomNameSql,String capacitySql,String statusSql,String descriptionSql){
		boolean flag=false;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement  statement=null;
		String sql="INSERT INTO MEETINGROOM VALUES(ROOMID_SEQ.NEXTVAL"+roomNumSql +roomNameSql +capacitySql+statusSql+descriptionSql+")";
		try {
			statement = conn.prepareStatement(sql);			
			statement.executeUpdate();
			if (statement!=null) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}
