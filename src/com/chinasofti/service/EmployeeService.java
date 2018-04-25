package com.chinasofti.service;

import java.util.List;

import com.chinasofti.bean.Employee;
import com.chinasofti.dao.EmployeeDao;

public class EmployeeService {
	public Integer loginService(String userName, String psw) {
		Employee emp = new EmployeeDao().selectByNamePwd(userName, psw);
		if (emp != null) {
			return Integer.parseInt(emp.getStatus());
		}
		return -1;
	}

	public Integer insertService(String name, String userName, String psw, String phone, String email,
			String department) {
		Employee emp = new EmployeeDao().selectByUserName(userName);
		if (emp == null) {
			boolean flag = new EmployeeDao().insertEmp(name, userName, psw, phone, email, department);
			if (flag) {
				return 1;
			}
		}
		return 0;
	}

	public Integer adminOrEmployeeService(String userName, String psw) {
		Employee emp = new EmployeeDao().selectByNamePwd(userName, psw);
		if (emp != null) {
			return Integer.parseInt(emp.getRole());
		}
		return 0;
	}

	public Integer approvalService(String userName, String status) {
		return new EmployeeDao().approvalEmp(userName, status);
	}

	public List<Employee> searchEmployeeService(String name, String userName, String status,int page) {
		String nameSql,userNameSql,statusSql;
		if (name!=null&&!"".equals(name)) {
			nameSql=" AND EMPLOYEENAME LIKE '%"+name+"%'";
		}else{
			nameSql="";
		}
		if (userName!=null&&!"".equals(userName)) {
			userNameSql=" AND USERNAME LIKE '%"+userName+"%'";
		}else{
			userNameSql="";
		}
		if (status!=null&&!"".equals(status)) {
			statusSql=" AND STATUS='"+status+"'";
		}else{
			statusSql="";
		}
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.searchEmployeeByNameStatus(nameSql, userNameSql, statusSql, page);
		
		return list;
	}
	public Integer searchEmployeeService_T(String name, String userName, String status,int pageInt) {
		String nameSql,userNameSql,statusSql;
		if (name!=null&&!"".equals(name)) {
			nameSql="AND EMPLOYEENAME LIKE '%"+name+"%'";
		}else{
			nameSql="";
		}
		if (userName!=null&&!"".equals(userName)) {
			userNameSql="AND USERNAME LIKE '%"+userName+"%'";
		}else{
			userNameSql="";
		}
		if (status!=null&&!"".equals(status)) {
			statusSql="AND STATUS='"+status+"'";
		}else{
			statusSql="";
		}
		EmployeeDao dao = new EmployeeDao();
		Integer rn = dao.searchEmployeeByNameStatus_other(nameSql, userNameSql, statusSql,pageInt);
	
		return rn;
	}
}
