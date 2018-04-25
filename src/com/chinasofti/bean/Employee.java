package com.chinasofti.bean;

public class Employee {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;
	private String userName;
	private String psw;
	private String status;
	private String role;
	private String phone;
	private String email;
	private Integer departmentid;
	
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", psw=" + psw + ", status=" + status + "]";
	}
	
	public Employee(String name, String userName, String phone, String email) {
		super();
		this.name = name;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee(Integer id,String name, String userName, String phone, String email, String status,Integer departmentid ,String psw, String role
			) {
		super();
		this.id=id;
		this.name = name;
		this.userName = userName;
		this.psw = psw;
		this.status = status;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.departmentid = departmentid;
	}
	
}
