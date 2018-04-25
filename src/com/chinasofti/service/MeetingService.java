package com.chinasofti.service;

import java.util.ArrayList;

import com.chinasofti.bean.Meeting;
import com.chinasofti.dao.MeetingDao;

public class MeetingService {
	public Integer resereserveMeeting(Integer reservationistId,
	String meetingName,
	String numberOfParticipants,
	String startTime,
	String endTime,
	String meetingRoomId ,
	String description){
		String meetingNameSql,numberOfParticipantsSql,startTimeSql,endTimeSql,meetingRoomIdSql,descriptionSql,reservationistIdSql;
		if (meetingName!=null&&!"".equals(meetingName)) {
			meetingNameSql=",'"+meetingName+"'";
		}else{
			meetingNameSql=",''";
		}
		if (meetingRoomId!=null&&!"".equals(meetingRoomId)) {
			meetingRoomIdSql=","+meetingRoomId;
		}else{
			meetingRoomIdSql=",''";
		}
		if (reservationistId!=null&&!"".equals(reservationistId)) {
			reservationistIdSql=","+reservationistId;
		}else{
			reservationistIdSql=",''";
		}
		if (numberOfParticipants!=null&&!"".equals(numberOfParticipants)) {
			numberOfParticipantsSql=","+numberOfParticipants;
		}else{
			numberOfParticipantsSql=",''";
		}
		if (startTime!=null&&!"".equals(startTime)) {
			startTimeSql=",to_date('"+startTime+"','yyyy-MM-dd HH24:mi:ss')";
		}else{
			startTimeSql=",''";
		}
		if (endTime!=null&&!"".equals(endTime)) {
			endTimeSql=",to_date('"+endTime+"','yyyy-MM-dd HH24:mi:ss')";
		}else{
			endTimeSql=",''";
		}
		if (description!=null&&!"".equals(description)) {
			descriptionSql=",'"+description+"'";
		}else{
			descriptionSql=",''";
		}
		MeetingDao dao = new MeetingDao();
		Integer meetingId = dao.reserveMeeting(meetingNameSql, meetingRoomIdSql, reservationistIdSql, numberOfParticipantsSql, startTimeSql, endTimeSql,  descriptionSql);
		
		return meetingId;
		
	}
	public ArrayList<Meeting> selectMeetingByEmpId(Integer empId){
		String empIdSql="''";
		if (empId!=null) {
			empIdSql=""+empId;
		}
		ArrayList<Meeting> list = new MeetingDao().selectMeetingByEmpId(empIdSql);
		return list; 
	}
	public Meeting selectMyBookingById(String meetingId){
		String meetingIdSql="0";
		if(meetingId!=null){
			meetingIdSql=meetingId;
		}
		Meeting meeting = new MeetingDao().selectMyBookingById(meetingIdSql);
		return meeting;
	}
}
