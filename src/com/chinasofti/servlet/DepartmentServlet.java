package com.chinasofti.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Department;
import com.chinasofti.dao.DepartmentDao;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ArrayList<Department> list = new DepartmentDao().selectDepartmentName();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Departments.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
