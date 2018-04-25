package com.chinasofti.service;

import java.util.ArrayList;

import com.chinasofti.bean.MeetingRoom;
import com.chinasofti.dao.MeetingRoomDao;

public class MeetingRoomService {
	public ArrayList<MeetingRoom> selectMeetingRoom(){
		ArrayList<MeetingRoom> list = new MeetingRoomDao().selectAllMeetingRoom();
		return list;
	}
	public MeetingRoom searchMeetingRoom(String roomIdStr){
		Integer roomId=0;
		if (roomIdStr!=null&&!"".equals(roomIdStr)) {
			roomId=Integer.parseInt(roomIdStr);
		}
		return new MeetingRoomDao().searchMeetingRoom(roomId);
	}
	public boolean insertMeetingRoom(String roomNumStr,String roomNameStr,String capacityStr,String statusStr,String descriptionStr){
		boolean flag=false;
		String roomIdSql,roomNumSql,roomNameSql,capacitySql,statusSql,descriptionSql;
		if (roomNumStr!=null&&!"".equals(roomNameStr)) {
			roomNumSql=",'"+roomNumStr+"'";
		}else{
			roomNumSql=",''";
		}
		if (roomNameStr!=null&&!"".equals(roomNameStr)) {
			roomNameSql=",'"+roomNameStr+"'";
		}else{
			roomNameSql=",''";
		}
		if (capacityStr!=null&&!"".equals(capacityStr)) {
			capacitySql=",'"+capacityStr+"'";
		}else{
			capacitySql=",''";
		}
		if (statusStr!=null&&!"".equals(statusStr)) {
			statusSql=",'"+statusStr+"'";
		}else{
			statusSql=",''";
		}
		if (descriptionStr!=null&&!"".equals(descriptionStr)) {
			descriptionSql=",'"+descriptionStr+"'";
		}else{
			descriptionSql=",''";
		}
		flag = new MeetingRoomDao().insertMeetingRoom(roomNumSql,roomNameSql,capacitySql,statusSql,descriptionSql);
		return flag;
		
	}
	public boolean updateMeetingRoom(String roomIdStr,String roomNumStr,String roomNameStr,String capacityStr,String statusStr,String descriptionStr){
		boolean flag=false;
		String roomIdSql,roomNumSql,roomNameSql,capacitySql,statusSql,descriptionSql;
		if (roomIdStr!=null&&!"".equals(roomIdStr)) {
			roomIdSql=roomIdStr;
		}else{
			roomIdSql="";
		}
		if (roomNumStr!=null&&!"".equals(roomNameStr)) {
			roomNumSql=roomNumStr;
		}else{
			roomNumSql="";
		}
		if (roomNameStr!=null&&!"".equals(roomNameStr)) {
			roomNameSql=roomNameStr;
		}else{
			roomNameSql="";
		}
		if (capacityStr!=null&&!"".equals(capacityStr)) {
			capacitySql=capacityStr;
		}else{
			capacitySql="";
		}
		if (statusStr!=null&&!"".equals(statusStr)) {
			statusSql=statusStr;
		}else{
			statusSql="";
		}
		if (descriptionStr!=null&&!"".equals(descriptionStr)) {
			descriptionSql=descriptionStr;
		}else{
			descriptionSql="";
		}
		flag = new MeetingRoomDao().updateMeetingRoom(roomIdSql,roomNumSql,roomNameSql,capacitySql,statusSql,descriptionSql);
		return flag;
	}
	
}
