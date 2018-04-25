<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预定会议</title>

<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>

<script type="text/javascript">
	
<%--window.onload=function(){
		window.location.href="ViewAllMeetingRoomNameServlet";
	}--%>
	var xmlHttp;
	function viewemp() {
		try{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
			xmlHttp=new XMLHttpRequest();
		}
		if (xmlHttp!=null) {
			var deptId=document.getElementById("department").value;
			var url="SelectEmpByDeptId?deptId="+escape(deptId);
			xmlHttp.open("GET",url,true);
			xmlHttp.onreadystatechange=callback;
			xmlHttp.send(null);
		}
	}
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				
				var res=xmlHttp.responseXML;
				var name=res.getElementsByTagName("empname");
				var empId=res.getElementsByTagName("empId");
				var tagText;
				for (var i = 0; i < empId.length; i++) {
					tagText=tagText+"<option value='"+empId[i].firstChild.data +"'>"+name[i].firstChild.data+"</option>"
				}
				document.getElementById("empName").innerHTML=tagText;
			}
		}
	}
</script>
</head>
<body>
<a href="adminleft.jsp">个人中心</a>>预定会议
<form id="from_1">
	<table>
		<tr>
			<td>会议名称</td>
			<td><input type="text" name="meetingName" id="meetingName"/></td>
		</tr>
		<tr>
			<td>预计参加人数</td>
			<td><input type="text" name="numberOfParticipants" id="numberOfPartipants" /></td>
		</tr>
		<tr>
			<td>预计开始时间</td>
			<td><input type="text" name="startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="startTime"/></td>
		</tr>
		<tr>
			<td>预计结束时间</td>
			<td><input type="text" name="endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="endTime"/></td>
		</tr>
		<tr>
			<td>选择会议室</td>
			<td><select name="meetingRoomName" id="meetingRoomName">
					<option value="" selected>-请选会议室-</option>
					<c:forEach var="meetingRoom" items="${requestScope.meetingRoomList}">
						<option value="${meetingRoom.roomId}">${meetingRoom.roomName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>会议说明</td>
			<td><textarea rows="3" cols="20" name="description" ></textarea></td>
		</tr>
		<tr>
			<td>选择参会人员</td>
			<td><select name="department" id="department" onchange="viewemp()">
					<option selected>-请选择部门-</option>
					<c:forEach var="dept" items="${requestScope.deptList}">
						<option value="${dept.departmentId}">${dept.departmentName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td></td>
			<td>
			<select name="empName" id="empName" multiple="multiple" size="5" >
			</select> 
				<input type="button" value="添加"  id="add"> 
				<input type="button" value="删除"  id="del">
			</td>
			<td>
				<select name="addEmpName" id="addEmpName" multiple="multiple" size="5"> 
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><input type="button" value="预定会议" id="reserve" onclick="reserve_1()">
				<input type="button" value="重置">
			</td>
		</tr>
	</table>
</form>
	<script type="text/javascript" >
		$("#add").click(function(){
			var $add=$("#empName option:selected").clone(true);
			$add.attr("selected","selected");
			$("#addEmpName").append($add);
			$("#empName option:selected").remove();
		});
		$("#del").click(function(){
			var $del=$("#addEmpName option:selected").clone(true);
			$del.attr("selected","selected");
			$("#empName").append($del);
			$("#addEmpName option:selected").remove();
		});
		
		<%--$("#reserve").click(function(){
			var $name=$("#meetingName").attr("value");
			var $number=$("#numberOfPartipants").val();
			var $startTime= $("#startTime").val();
			var $endTime=$("input[name='endTime']").val();
			var $meetingRoomId =$("#meetingRoomName").val();
			var $description=$("textarea[name='description']").val();
			var $empName=$("#addEmpName option:selected").toArray();
			var $empId
		
			for (var i = 0; i < $empName.length; i++) {
				$empId.($($empId[i]).attr("value"));
			}
		});--%>
		function reserve_1(){
			var form_1=document.getElementById("from_1");
			form_1.action="ReserveMeetingServlet";
			form_1.submit();
		}
	</script>
</body>
</html>