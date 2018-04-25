package com.chinasofti.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Employee;
import com.chinasofti.dao.EmployeeDao;
public class ViewApprovalEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewApprovalEmp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmployeeDao dao = new EmployeeDao();
		ArrayList<Employee> list = dao.viewALLApprovalEmp();
		request.setAttribute("list", list);
		request.getRequestDispatcher("approval.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
