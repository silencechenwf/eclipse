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
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
</head>
<body>
	<a href="adminleft.jsp">个人中心</a>>我的预定
	<h4>我预定的会议</h4>
	<table>
		<tr id="yemei">
			<td>会议名称</td>
			<td>会议室名称</td>
			<td>会议开始时间</td>
			<td>会议结束时间</td>
			<td>会议预定时间</td>
			<td>操作</td>
		</tr>
		<c:forEach var="meeting" items="${requestScope.bookingList}">
		<tr>
			<td>${meeting.meetingName}</td>
			<td>${meeting.roomName}</td>
			<td>${meeting.startTime}</td>
			<td>${meeting.endTime}</td>
			<td>${meeting.reservationTime}</td>
			<td><input  value="${meeting.meetingId}" class="meetingId" id="${meeting.meetingId}">
				<c:if test="${meeting.status eq '0'}"><input type="button" value="查看/取消" id="qq66" onclick="sel('${meeting.meetingId}','0')"></c:if>
				<c:if test="${meeting.status eq '1'}"><input type="button" value="查看/已取消" id="qq6" ></c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".meetingId").hide();
		});
		function sel(data1,data2){
			window.location.href="SelectMyBookingServlet?meetingId="+data1+"&status="+data2;
		}
	</script>
	
</body>
</html>