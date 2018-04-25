package com.chinasofti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Employee;
import com.chinasofti.dao.EmployeeDao;

public class SelectEmpById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectEmpById() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		System.out.println(deptId);
		List<Employee> list = new EmployeeDao().selectEmpByDeptId(deptId);
		if (list.isEmpty()) {
			request.setAttribute("msg", "该部门没有员工数据");
			request.getRequestDispatcher("reserveMeeting.jsp").forward(request, response);
		}else{
		request.setAttribute("empList", list);
		request.getRequestDispatcher("reserveMeeting.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
