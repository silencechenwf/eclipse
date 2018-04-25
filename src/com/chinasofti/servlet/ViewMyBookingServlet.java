package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.bean.Meeting;
import com.chinasofti.service.MeetingService;

public class ViewMyBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMyBookingServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object empIdObject =  session.getAttribute("id");
		Integer empId=(Integer) empIdObject;
		ArrayList<Meeting> list = new MeetingService().selectMeetingByEmpId(empId);
		request.setAttribute("bookingList", list);
		request.getRequestDispatcher("myBooking.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
