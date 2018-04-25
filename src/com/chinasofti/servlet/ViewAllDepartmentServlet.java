package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Department;
import com.chinasofti.dao.DepartmentDao;

public class ViewAllDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewAllDepartmentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Department> list = new DepartmentDao().selectDepartmentName();
		request.setAttribute("deptList", list);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
