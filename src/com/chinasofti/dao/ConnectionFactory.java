package com.chinasofti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String CLASSNAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USERNAME="scott";
	public static final String PASSWORD="tiger";
	public static Connection getConnection(){
		try {
			Class.forName(CLASSNAME);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动未找到");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接异常");
			e.printStackTrace();
		}
		return null;
	}
}
