package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.MeetingRoom;
import com.chinasofti.service.MeetingRoomService;

public class SelectAllMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllMeetingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingRoomService roomService = new MeetingRoomService();
		ArrayList<MeetingRoom> list = roomService.selectMeetingRoom();
		if (list.isEmpty()) {
			request.setAttribute("msg", "会议室没有数据");
			request.getRequestDispatcher("selectMeetingRoom.jsp").forward(request, response);
		}else{
			request.setAttribute("list", list);
			request.getRequestDispatcher("selectMeetingRoom.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
