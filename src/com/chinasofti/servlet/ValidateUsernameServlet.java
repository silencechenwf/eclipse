package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Employee;
import com.chinasofti.dao.EmployeeDao;

public class ValidateUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateUsernameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp = new EmployeeDao().selectByUserName(request.getParameter("userName"));
		boolean flag = false;
		System.out.println(request.getParameter("userName"));
		String message = "";
		if (emp == null) {
			flag = true;
			message = "用户名可以使用";
		} else {
			message = "用户名已存在";
		}
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");
		out.println("<?xml version='1.0' encoding='utf-8' ?>");
		out.println("<response>");
		out.println("<pass>" + Boolean.toString(flag) + "</pass>");
		out.println("<message>" + message + "</message>");
		out.println("</response>");
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
