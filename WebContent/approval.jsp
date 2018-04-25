<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function yes(data,data1){
		alert(data+"通过审核");
		window.location.href="ApprovalServlet?userName="+data+"&status="+data1;
	}
	function no(data,date1){
		alert(data+"审核不通过");
		window.location.href="ApprovalServlet?userName="+data+"&status="+data1;
	}

</script>
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
<title>审批信息</title>
</head>
<body>
<a href="adminleft.jsp">个人中心</a>>注册审批
<h4>所有注册待审批信息</h4>
<table>
	<tr id="yemei">
		<td>姓名</td>
		<td>账号名</td>
		<td>联系电话</td>
		<td>电子邮件</td>
		<td>操作</td>
	</tr>
	<c:forEach var="emp" items="${requestScope.list}">
	<tr>
		<td>${emp.name}</td>
		<td>${emp.userName}</td>
		<td>${emp.phone}</td>
		<td>${emp.email}</td>
		<td><input type="button" value="通过" name="one" onclick="yes('${emp.userName}','1')"><input type="button" value="不通过" name="two" id="two" onclick="no('${emp.userName}','2')"></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>