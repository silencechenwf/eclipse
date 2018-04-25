<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<style type="text/css">
table{
		border-color: aqua;
		border-style: solid;
		border-width: 1px;
	}
	tr{
		border-style:solid;
		border-width: 1px;
	}
	td{
		width:100px;
		border-style:solid;
		border-width: 1px;
		text-align: center;
	}
	input{
		text-align: center;
	}
	#yemei{
		background-color: green;
	}
</style>
</head>
<body>
<a href="ViewMyBookingServlet">会议预定</a>>修改会议预定
<h4>会议信息</h4>
<table>
	<tr><td>会议名称</td><td>${requestScope.meeting.meetingName}</td></tr>
	<tr><td>预计参加人数</td><td>${requestScope.meeting.numberOfParticipants}</td></tr>
	<tr><td>预计开始时间</td><td>${requestScope.meeting.startTime}</td></tr>
	<tr><td>预计结束时间</td><td>${requestScope.meeting.endTime}</td></tr>
	<tr><td>会议说明</td><td>${requestScope.meeting.description}</td></tr>
	<table>
	<tr><td>参会人员</td>
						<td id="yemei">姓名</td><td id="yemei">联系电话</td><td id="yemei">电子邮件</td></tr>
							   <c:forEach var="emp" items="${requestScope.empList}">
							   <tr>
							   		<td></td>
							   		<td>${emp.userName}</td>
							   		<td>${emp.phone}</td>
							   		<td>${emp.email}</td>
							   </tr>
							   </c:forEach>
						
						</table>
						<tr><td><input type="button" value="取消会议" id="status"><input type="button" value="返回"></td></tr>
</table>
<script type="text/javascript">
	$("#status").click(function(){
		window.location.href="UpdateStatusOfMeeting";
	});
	
</script>
</body>
</html>