package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.service.EmployeeService;

public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApprovalServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String status=request.getParameter("status");
		String userName = request.getParameter("userName");
		if(status.equals("3")){
			status="2";
			EmployeeService service = new EmployeeService();
			Integer emp = service.approvalService(userName, status);
			if (emp==1) {
				request.getRequestDispatcher("searchEmployee.jsp").forward(request, response);

			}
		}else{
			EmployeeService service = new EmployeeService();
			Integer emp = service.approvalService(userName, status);
			if(emp==1){
				request.getRequestDispatcher("ViewApprovalEmp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
