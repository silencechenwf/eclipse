package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.bean.Employee;

public class EmployeeDao {
	private PreparedStatement prepareStatement;
	private Connection conn = ConnectionFactory.getConnection();
	private String sql;
	private Statement statement;
	private ResultSet rs;

	public Employee selectByNamePwd(String userName, String psw) {
		sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=? AND PASSWORD=?";
		Employee emp = null;
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, userName);
			prepareStatement.setString(2, psw);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Integer id=rs.getInt("EMPLOYEEID");
				String name = rs.getString("EMPLOYEENAME");
				String status = rs.getString("STATUS");
				String role = rs.getString("ROLE");
				emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setUserName(userName);
				emp.setPsw(psw);
				emp.setRole(role);
				emp.setStatus(status);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emp;
	}

	public Employee selectByUserName(String userName) {
		sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=?";
		Employee emp = null;
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, userName);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setName(rs.getString("EMPLOYEENAME"));
				emp.setUserName(userName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emp;
	}

	public boolean insertEmp(String name, String userName, String psw, String phone, String email, String department) {
		sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTNAME=?";
		boolean flag = false;
		Integer departmentid = null;
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, department);
			rs = prepareStatement.executeQuery();
			if (rs.next()) {
				departmentid = rs.getInt("DEPARTMENTID");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		sql = "INSERT INTO EMPLOYEE(EMPLOYEEID,EMPLOYEENAME,USERNAME,PHONE,EMAIL,DEPARTMENTID,PASSWORD)VALUES(EMPLOYEEID_SEQ.NEXTVAL,?,?,?,?,?,?)";
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, userName);
			prepareStatement.setString(3, phone);
			prepareStatement.setString(4, email);
			prepareStatement.setInt(5, departmentid);
			prepareStatement.setString(6, psw);
			prepareStatement.executeUpdate();
			if (prepareStatement != null) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public ArrayList<Employee> viewALLApprovalEmp() {
		sql = "SELECT * FROM EMPLOYEE WHERE STATUS='0'";
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee(rs.getString("EMPLOYEENAME"), rs.getString("USERNAME"),
						rs.getString("PHONE"), rs.getString("EMAIL"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (list.isEmpty()) {
			return null;
		}
		return list;
	}

	public Integer approvalEmp(String userName, String status) {
		sql = "UPDATE EMPLOYEE SET STATUS=? WHERE USERNAME=?";
		Integer flag = 0;
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, status);
			prepareStatement.setString(2, userName);
			prepareStatement.executeUpdate();
			if (prepareStatement != null) {
				flag = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public ArrayList<Employee> searchEmployeeByNameStatus_another(String name, String userName, String status) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		String sql = "";
		// name为空 true
		boolean a = (name == null || "".equals(name));
		// userName为空true
		boolean b = (userName == null || "".equals(userName));
		// status=3为全部状态
		boolean c = ("3".equals(status) || status == null);
		// 员工状态 0:未审核;1:已通过;2:不通过;3:全部人员
		if (c && !b && !a) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.USERNAME=? AND E.EMPLOYEENAME=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, userName);
				prepareStatement.setString(2, name);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (c && b && !a) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.USERNAME=? AND E.EMPLOYEENAME=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, userName);
				prepareStatement.setString(2, name);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!c && !b && a) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.STATUS=? AND E.USERNAME=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, status);
				prepareStatement.setString(2, userName);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!c && b && !a) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.STATUS=? AND E.EMPLOYEENAME=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, status);
				prepareStatement.setString(2, name);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!c && a && b) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.STATUS=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, status);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (a && b && c) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E";
			try {
				statement = conn.createStatement();
				rs = statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!a && !b && !c) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.STATUS=? AND E.USERNAME=? AND E.EMPLOYEENAME=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, status);
				prepareStatement.setString(2, userName);
				prepareStatement.setString(3, name);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (a && !b && c) {
			sql = "SELECT E.EMPLOYEENAME,E.USERNAME,E.PHONE,E.EMAIL FROM EMPLOYEE E WHERE E.USERNAME=?";
			try {
				prepareStatement = conn.prepareStatement(sql);
				prepareStatement.setString(1, userName);
				rs = prepareStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("EMPLOYEENAME"));
				emp.setUserName(rs.getString("USERNAME"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public Integer searchEmployeeByNameStatus_other(String nameSql, String userNameSql, String statusSql,
			int page) {
		Integer rn=0;
		sql = "SELECT ROWNUM,E.* FROM EMPLOYEE E WHERE ROLE='2'" + nameSql + userNameSql + statusSql;
		try {
			prepareStatement = conn.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				rn=Integer.parseInt(rs.getString("ROWNUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rn;
	}

	public List<Employee> searchEmployeeByNameStatus(String nameSql, String userNameSql, String statusSql,
			int pageInt) {
		List<Employee> list = new ArrayList<Employee>();
		int row = (pageInt-1)* 8;
		int row2=row+8;
		sql = "SELECT * FROM ( SELECT ROWNUM RN,A.* FROM(SELECT E.* FROM EMPLOYEE E WHERE ROLE='2'" + nameSql
				+ userNameSql + statusSql + ")A  WHERE ROWNUM<" + row2 + ")B  WHERE B.RN>" + row;

		

		try {
			prepareStatement = conn.prepareStatement(sql);

			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("EMPLOYEENAME"));
				emp.setUserName(rs.getString("USERNAME"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setStatus(rs.getString("STATUS"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public List<Employee> selectEmpByDeptId(String deptIdSql){
		sql="SELECT * FROM EMPLOYEE WHERE departmentid="+deptIdSql;
		List<Employee> list=new ArrayList<Employee>();
		try {
			prepareStatement=conn.prepareStatement(sql);
			rs=prepareStatement.executeQuery();
			while(rs.next()){
				Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement!=null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
