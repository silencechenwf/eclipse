<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<a href="adminleft.jsp">个人中心</a>>添加会议室
<form id="form_1">
<table>
	<tr><td>门牌号:</td><td><input type="text" name="roomNum" ></td>
	</tr>
	<tr><td>会议室名称:</td><td><input type="text" name="roomName" ></td>
	</tr>
	<tr><td>最多容纳人数:</td><td><input type="text" name="capacity" ></td>
	</tr>
	<tr><td>当前状态:</td>
		<td>
		<input type="radio" name="status" value="1" />不可用
		<input type="radio" name="status" value="0" />可用
		</td>
	</tr>
	<tr><td>备注:</td><td><textarea rows="3" name="description" cols="20"></textarea></td>
	</tr>
</table>
	<input type="button" value="确认提交" onclick="updateData()"><input type="button" value="返回" onclick="back()">
</form>
<script type="text/javascript">
	function back(){
		window.location.href="SelectAllMeetingRoomServlet";
	}
	function updateData(data){
		var form_1=document.getElementById("form_1");
		form_1.action="InsertMeetingRoomServlet";
		form_1.submit();
	}
</script>

</body>
</html>