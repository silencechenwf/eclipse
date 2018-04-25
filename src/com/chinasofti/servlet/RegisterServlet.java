package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.service.EmployeeService;

public class RegisterServlet extends HttpServlet {
	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = null;
		String userName = null;
		String phone = null;
		String email = null;
		String department = null;
		name = request.getParameter("name");
		userName = request.getParameter("userName");
		String psw = request.getParameter("psw");
		phone = request.getParameter("phone");
		email = request.getParameter("email");
		department = request.getParameter("department");
		int insertService = new EmployeeService().insertService(name, userName, psw, phone, email, department);
		if (insertService == 1) {
			request.setAttribute("msg", "注册成功,正在等待审核");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
//		if (insertService == 0) {
//			request.setAttribute("name",name);
//			request.setAttribute("userName", userName);
//			request.setAttribute("phone", phone);
//			request.setAttribute("email", email);
//			request.setAttribute("department", department);
//			request.setAttribute("msg", "用户名已存在,请重新注册");
//			request.getRequestDispatcher("register.jsp").forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
