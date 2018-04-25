package com.chinasofti.service;

import java.util.ArrayList;

import com.chinasofti.bean.Department;
import com.chinasofti.dao.DepartmentDao;

public class DepartmentService {
	public Integer selectDepartmentService(){
		Integer flag=-1;
		ArrayList<Department> list = new DepartmentDao().selectDepartmentName();
		if (!list.isEmpty()) {
			flag=1;
		}
		return flag;
	}
	public Integer deleteDepartmentService(String delName){
		Integer flag=-1;
		boolean d = new DepartmentDao().deleteDepartment(delName);
		if(d){
			flag=1;
		}
		return flag;
	}
	public Integer insertDepartmentService(String addName){
		Integer flag=-1;
		boolean b = new DepartmentDao().insertDepartment(addName);
		if (b) {
			flag=1;
		}
		return flag;
	}
}
