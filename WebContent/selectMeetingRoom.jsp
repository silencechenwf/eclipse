<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border-color: black;
		border-width: 1px;
		text-align: center;
		
	}
	td{
		border-style: solid;
		border-width: 1px;
	}
	#yemei td{
		background-color: green;
	}
</style>
</head>
<body>
<a href="adminleft.jsp">个人中心</a>>查看会议室
<h4>所有会议内容</h4>
<table>
	<tr id="yemei">
		<td>门牌编号</td>
		<td>会议室名称</td>
		<td>容纳人数</td>
		<td>当前状态</td>
		<td>操作</td>
	</tr>
	<c:forEach var="meetingRoom" items="${requestScope.list}">
	<tr>
		<td>${meetingRoom.roomNum}</td>
		<td>${meetingRoom.roomName}</td>
		<td>${meetingRoom.capacity}</td>
		<td><c:if test="${meetingRoom.status eq 0}">可用</c:if>
		<c:if test="${meetingRoom.status eq 1}">不可用</c:if></td>
		<td><input type="button" value="查看详情" onclick="searchData('${meetingRoom.roomId}')"></td>
	</tr>
	</c:forEach>
</table>
<script type="text/javascript">
	function searchData(data1,data2,data3,data4){
		alert(data1);
		window.location.href="SearchMeetingRoomServlet?roomId="+data1;
	}
</script>
</body>
</html>