package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.service.MeetingRoomService;
import com.chinasofti.service.MeetingService;
import com.chinasofti.service.MeetingparticipantsService;
public class ReserveMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReserveMeetingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer reservationistId = (Integer) session.getAttribute("id");
		String meetingName = request.getParameter("meetingName");
		String numberOfParticipants = request.getParameter("numberOfParticipants");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String meetingRoomId = request.getParameter("meetingRoomName");
		String description = request.getParameter("description");
		String[] addEmpId = request.getParameterValues("addEmpName");
		System.out.println(startTime);
		System.out.println(endTime);
		MeetingService service = new MeetingService();
		Integer meetingId = service.resereserveMeeting(reservationistId, meetingName, numberOfParticipants, startTime, endTime, meetingRoomId, description);
		MeetingparticipantsService service2 = new MeetingparticipantsService();
		boolean meetingparticipants = service2.insertMeetingparticipants(meetingId, addEmpId);
		if (meetingparticipants) {
			request.setAttribute("msn", "预定成功");
			request.getRequestDispatcher("null.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
