package com.chinasofti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.service.DepartmentService;

public class AddAndDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAndDelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delName = request.getParameter("deleteName");
		String addName = request.getParameter("addName");
		DepartmentService service = new DepartmentService();
		if (delName!=null) {//删除部门
			Integer servlet = service.deleteDepartmentService(delName);
			if (servlet==1) {
				request.getRequestDispatcher("DepartmentServlet").forward(request, response);
			}
		}
		if (addName!=null) {//添加部门
			Integer servlet = service.insertDepartmentService(addName);
			if (servlet==1) {
				request.getRequestDispatcher("DepartmentServlet").forward(request,response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
