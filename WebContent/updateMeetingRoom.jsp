<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>会议室信息</h4><br>
<form id="form_1">
<table>
	<tr><td>门牌号:</td><td><input type="text" name="roomNum" value="${requestScope.room.roomNum}"></td>
	</tr>
	<tr><td>会议室名称:</td><td><input type="text" name="roomName" value="${requestScope.room.roomName}"></td>
	</tr>
	<tr><td>最多容纳人数:</td><td><input type="text" name="capacity" value="${requestScope.room.capacity}"></td>
	</tr>
	<tr><td>当前状态:</td>
		<td>
		<input type="radio" name="status" value="1" <c:if test="${requestScope.room.status eq 1}">checked</c:if>/>不可用
		<input type="radio" name="status" value="0" <c:if test="${requestScope.room.status eq 0}">checked</c:if>/>可用
		</td>
	</tr>
	<tr><td>备注:</td><td><textarea rows="3" name="description" cols="20">${requestScope.room.description}</textarea></td>
	</tr>
</table>
	<input type="button" value="确认提交" onclick="updateData('${requestScope.room.roomId}')"><input type="button" value="返回" onclick="back()">
</form>
<script type="text/javascript">
	function back(){
		window.location.href="SelectAllMeetingRoomServlet";
	}
	function updateData(data){
		var form_1=document.getElementById("form_1");
		form_1.action="UpdateMeetingRoomServlet";
		form_1.submit();
	}
</script>
</body>
</html>