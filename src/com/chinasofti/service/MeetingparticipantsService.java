package com.chinasofti.service;
import java.util.ArrayList;
import com.chinasofti.bean.Employee;
import com.chinasofti.dao.MeetingparticipantsDao;

public class MeetingparticipantsService {
	public boolean insertMeetingparticipants(Integer meetingId, String[] empId) {
		boolean flag = false;
		String meetingIdSql = String.valueOf(meetingId);
		String empIdSql;
		MeetingparticipantsDao dao = new MeetingparticipantsDao();
		for (int i = 0; i < empId.length; i++) {
			empIdSql = empId[i];
			flag = dao.insertMeetingparticipants(meetingIdSql, empIdSql);

		}
		return flag;
	}

	public ArrayList<Employee> selectMyBooking(String meetingId) {
		String meetingIdSql = "0";
		if (meetingId != null) {
			meetingIdSql = meetingId;
		}
		MeetingparticipantsDao dao = new MeetingparticipantsDao();
		ArrayList<Employee> list = dao.selectEmpByMeetingId(meetingIdSql);
		return list;
	}
}
