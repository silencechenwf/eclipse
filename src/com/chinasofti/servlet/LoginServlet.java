package com.chinasofti.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.bean.Employee;
import com.chinasofti.dao.EmployeeDao;
import com.chinasofti.service.EmployeeService;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext servletContext = this.getServletContext();
		Object attribute = servletContext.getAttribute("counts");
		int counts = 0;// 声明计数器
		counts = (int) attribute;
		counts++;
		servletContext.setAttribute("counts", counts);
		String userName = request.getParameter("userName");
		String psw = request.getParameter("psw");
		String selectTime = request.getParameter("selectTime");
		int days = 0;
		if (selectTime != null && !"null".equals(selectTime)) {
			days = Integer.parseInt(selectTime);
		}
		Employee emp = new EmployeeDao().selectByNamePwd(userName, psw);
		String msg = null;
		if (emp != null) {
			String status = emp.getStatus();
			String role = emp.getRole();
			System.out.println("状态" + emp.getStatus());
			System.out.println("---------");
			System.out.println("身份" + emp.getRole());
			if (emp.getStatus() != null) {
				/*
				 * 0：待审批 1：审批通过 2：审批未通过
				 */
				switch (status) {
				case "0":
					msg = "待审批,登录失败";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
				case "1":
					// 1:管理员登陆;2:普通用户登陆
					msg = "登录成功";
					if (days != 0) {
						Cookie cookieUserName = new Cookie("userName", userName);
						Cookie cookiePsw = new Cookie("psw", psw);
						Cookie cookieRole = new Cookie("role", role);
						cookieUserName.setMaxAge(days * 24 * 3600);
						cookiePsw.setMaxAge(days * 24 * 3600);
						cookieRole.setMaxAge(days * 24 * 3600);
						response.addCookie(cookieUserName);
						response.addCookie(cookiePsw);
						response.addCookie(cookieRole);
					}
					HttpSession session = request.getSession();
					session.setAttribute("userName", emp.getName());
					session.setAttribute("id", emp.getId());
					request.setAttribute("msg", msg);
					switch (emp.getRole()) {
					case "1":
						request.getRequestDispatcher("admin/adminindex.jsp").forward(request, response);
						break;
					case "2":
						request.getRequestDispatcher("admin/employeeindex.jsp").forward(request, response);
						break;
					}
					break;
				case "2":
					msg = "审批未通过,登陆失败";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
				default:
					msg = "员工状态异常,请查询";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
				}

			}
		} else {
			msg = "帐号密码错误,登录失败";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
