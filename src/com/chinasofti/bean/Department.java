package com.chinasofti.bean;

public class Department {
	private int departmentId;
	private String departmentName;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department( int departmentId,String departmentName) {
		super();
		this.departmentName = departmentName;
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Department [DepartmentName=" + getDepartmentName() + ", DepartmentId=" + getDepartmentId() + "]";
	}

}
