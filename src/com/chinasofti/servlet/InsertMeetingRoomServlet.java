package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.service.MeetingRoomService;

public class InsertMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMeetingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomNum = request.getParameter("roomNum");
		String roomName = request.getParameter("roomName");
		String capacity = request.getParameter("capacity");
		String status = request.getParameter("status");
		String description = request.getParameter("description");
		boolean insert = new MeetingRoomService().insertMeetingRoom(roomNum,roomName,capacity,status,description);
		if(insert){
			request.getRequestDispatcher("SelectAllMeetingRoomServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
