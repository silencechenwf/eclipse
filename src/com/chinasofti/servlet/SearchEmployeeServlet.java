package com.chinasofti.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.bean.Employee;
import com.chinasofti.service.EmployeeService;

public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String userName = request.getParameter("userName");
		String status = request.getParameter("status");
		String pageNum = request.getParameter("page");
		Integer pageInt = 1;
		if (pageNum != null && !"".equals(pageNum)) {
			pageInt = Integer.parseInt(pageNum);
		}
		EmployeeService service = new EmployeeService();
		Integer count = service.searchEmployeeService_T(name, userName, status, pageInt);
		List<Employee> list = service.searchEmployeeService(name, userName, status, pageInt);
		if (!list.isEmpty()) {
			int pageCount = 0;
			if (count > 0) {
				pageCount = 1;
			}
			if (count > 8) {
				pageCount = count / 8 + 1;
			}
			request.setAttribute("count", "共" + count + "条结果,");
			request.setAttribute("page", "当前第" + pageInt + "页");
			request.setAttribute("pageCount", "共" + pageCount + "页,");
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchEmployee.jsp").forward(request, response);
		} else {
			request.setAttribute("msn", "没有符合的数据");
			request.getRequestDispatcher("searchEmployee.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
