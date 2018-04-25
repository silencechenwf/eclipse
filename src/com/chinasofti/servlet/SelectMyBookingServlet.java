package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Employee;
import com.chinasofti.bean.Meeting;
import com.chinasofti.service.MeetingService;
import com.chinasofti.service.MeetingparticipantsService;
public class SelectMyBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMyBookingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String meetingId = request.getParameter("meetingId");
		String status=request.getParameter("status");
		ArrayList<Employee> empList = new MeetingparticipantsService().selectMyBooking(meetingId);
		Meeting meeting = new MeetingService().selectMyBookingById(meetingId);
		request.setAttribute("empList", empList);
		request.setAttribute("meeting", meeting);
		request.setAttribute("status", status);
		request.getRequestDispatcher("selectMyBooking.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
