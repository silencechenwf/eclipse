package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Department;
import com.chinasofti.bean.MeetingRoom;
import com.chinasofti.dao.DepartmentDao;
import com.chinasofti.service.MeetingRoomService;

public class ViewAllMeetingRoomNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllMeetingRoomNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoomService roomService = new MeetingRoomService();
		ArrayList<MeetingRoom> meetingRoomList = roomService.selectMeetingRoom();
		ArrayList<Department> deptList = new DepartmentDao().selectDepartmentName();
		
		request.setAttribute("meetingRoomList", meetingRoomList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("reserveMeeting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
