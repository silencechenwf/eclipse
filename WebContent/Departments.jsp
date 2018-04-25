<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
<style type="text/css">
	table{
		border-style: solid;
		border-color: black;
		border-width: 1px;
		width: 80%;
		height: 50px;
	}

</style>
<script type="text/javascript">
	function del(date){
		alert(date+"被删除");
		window.location.href="AddAndDelServlet?deleteName="+date;
	}
	function adddept(){
		form_.action="AddAndDelServlet";
		form_.submit();
	}
</script>
<style type="text/css">
	table{
		border-color: aqua;
		border-style: solid;
		border-width: 1px;
	}
	tr{
		width:90%;
		border-style:solid;
		border-width: 1px;
	}
	td{
		width:30%;
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
	.yemei input{
		text-align: left;
	}
	.yemei{
		text-align: left;
	}
</style>
</head>
<body>
	<a href="adminleft.jsp">个人中心</a>>部门管理
	<h4>添加部门</h4>
	<table>
		<tr><td class="yemei"><form id="form_">部门名称:<input type="text" name="addName"><input type="button" value="添加" onclick="adddept()"></form></td></tr>
	</table>
	<table>
		<tr id="yemei">
		<td>部门编号</td>
		<td>部门名称</td>
		<td>操作</td>
		</tr>
		<p:forEach var="dept" items="${requestScope.list}">
		<tr>
			<td>${dept.departmentId}</td>
			<td>${dept.departmentName}</td>
			<td><input type="button" value="删除" onclick="del('${dept.departmentName}')"></td>
		</tr>
		</p:forEach>
	</table>
</body>
</html>