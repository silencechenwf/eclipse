package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.bean.Employee;
import com.chinasofti.dao.EmployeeDao;

public class SelectEmpByDeptId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectEmpByDeptId() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		List<Employee> empList = new EmployeeDao().selectEmpByDeptId(deptId);
		request.setAttribute("empList", empList);
//		request.getRequestDispatcher("reserveMeeting.jsp").forward(request, response);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
//		response.setHeader("Cache-Control", "no-cache");
		out.println("<?xml version='1.0' encoding='utf-8' ?>");
		out.println("<response>");
		for (Employee employee : empList) {
			out.println("<empname>");
			out.println(employee.getName()+"");
			out.println("</empname>");
			out.println("<empId>");
			out.println(employee.getId()+"");
			out.println("</empId>");
		}
		out.println("</response>");
		out.flush();
		out.close();
		
	}
	/*
	 *   JSONArray json = JSONArray.fromObject(ruleListTmp);  
            String jsonStr = json.toString();  
              
            response.getWriter().print(jsonStr);  
            response.getWriter().flush();  
            response.getWriter().close(); 
	 * 
	 * 
	 * 
	 * 
	 * */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
