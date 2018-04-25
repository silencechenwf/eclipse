<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索员工</title>
<style type="text/css">
	table{
		border-color: aqua;
		border-style: solid;
		border-width: 1px;
	}
	tr{
		width:100%;
		border-style:solid;
		border-width: 1px;
		height: 80px;
	}
	td{
		width:20%;
		border-style:solid;
		border-width: 1px;
		text-align: center;
	}
	input{
		text-align: left;
	}
	#tr2{
		background-color: green;
	}
	.yemei{
		text-align: center;
	}
	#table2{
		width: 100%;
	}
	div{
		color: red;
	}
	h2{
		text-align: center;
	}
</style>
</head>
<body>
<a href="adminleft.jsp">个人中心</a>>搜索员工
<table id="table1">
	<tr>
		<td class="yemei">
			<form id="form_1">
				姓名:&emsp;<input type="text" name="name" id="name">
				帐号名:<input type="text" name="userName" id=userName>
				状态:&emsp;<input type="radio" value="0" name="status">未审核
					<input type="radio" value="1" name="status">已批准
					<input type="radio" value="2" name="status">已关闭
					<input type="radio" value="" name="status">所有
				<br>
				<input type="button" value="查询" onclick="searchEmp()"><input type="reset" value="重置">
			</form>
		</td>
	</tr>
</table>
<h2>查询结果</h2>
<table>
<tr>
<td><div><font>${requestScope.count}${requestScope.pageCount}${requestScope.page}</font></div></td>
	<td>
		<form id="form_2">
		<input type="button" value="首页" >
		<input type="button" value="上页" >
		<input type="button" value="下页">
		<input type="button" value="末页">
		跳转到第<input type="text" name="page" id="page">页
		<input type="button" value="跳转" onclick="setPage('${param.name}','${param.userName}','${param.status}')" >
		</form>
	</td>
</tr>
</table>
<table id="table2">
	
	<tr id="tr2">
		<td>姓名</td>
		<td>帐号名</td>
		<td>电话</td>
		<td>电子邮件</td>
		<td>操作</td>
	</tr>
	<c:forEach var="emp" items="${requestScope.list}">
	<tr>
		<td>${emp.name}</td>
		<td>${emp.userName}</td>
		<td>${emp.phone}</td>
		<td>${emp.email}</td>
		<td><c:if test="${emp.status ne '2'}"><input type="button" value="关闭" onclick="closeEmp('${emp.userName}','3','${emp.name}')"></c:if>
			<c:if test="${emp.status eq '2'}">已关闭</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
	<div>${requestScope.msn}</div>
	
<script type="text/javascript">
	function searchEmp(){
		form_1.action="SearchEmployeeServlet";
		form_1.submit();
	}
	function setPage(data1,data2,data3){
		var page=document.getElementById("page").value;
		window.location.href="SearchEmployeeServlet?name="+data1+"&userName="+data2+"&status="+data3+"&page="+page;
	}
	function closeEmp(data1,data2,data3){
		alert("员工"+ data3 +"已关闭");
		window.location.href="ApprovalServlet?userName="+data1+"&status="+data2;
	}
</script>

</body>
</html>