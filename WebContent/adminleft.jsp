<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	a{
		text-decoration:none;
	}
</style>
<title>管理员</title>
</head>
<body>
<h4>个人中心</h4>
<a href="">最新通知</a><br>
<a href="ViewMyBookingServlet">我的预定</a><br>
<a href="">我的会议</a><br>
<h4>人员管理</h4>
<a href="DepartmentServlet">部门管理</a><br>
<a href="ViewApprovalEmp">注册审批</a><br>
<a href="searchEmployee.jsp">搜索员工</a><br>
<h4>会议预定</h4>
<a href="insertMeetingRoom.jsp">添加会议室</a><br>
<a href="SelectAllMeetingRoomServlet">查看会议室</a><br>
<a href="ViewAllMeetingRoomNameServlet">预定会议</a><br>
</body>
</html>