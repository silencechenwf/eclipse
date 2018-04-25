<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
	function registerEmp(){
		var userName=document.getElementById("userName").value;
		var psw=document.getElementById("psw").value;
		var psw1=document.getElementById("psw1").value;
		if (userName==null||""==userName) {
			var userMsg=document.getElementById("userMsg");
			userMsg.innerHTML="<font color=red>用户名不能为空</font>";
		}
		if (psw==psw1&&userName!=null&&""!=userName) {
			var form_=document.getElementById("form_2");
			form_.action="RegisterServlet";
			form_.submit();
		}
	}
	function checkpsw(){
		var psw=document.getElementById("psw").value;
		var psw1=document.getElementById("psw1").value;
		if (psw!=psw1) {
			var pswMsg=document.getElementById("pswMsg");
			pswMsg.innerHTML="<font color=red>密码不一致</font>";
		}else{
			var pswMsg=document.getElementById("pswMsg");
			pswMsg.innerHTML="";
		}
	}
	var xmlHttp;
	function createXMLHttpRequest(){
		try{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
			xmlHttp=new XMLHttpRequest();
		}
	}
	function validate(){
		createXMLHttpRequest();
		var userName=document.getElementById("userName").value;
		var url="ValidateUsernameServlet?userName="+escape(userName);
		xmlHttp.open("GET",url,true);
		xmlHttp.onreadystatechange=callback;
		xmlHttp.send(null);
	}
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var colorfont="red";
				var res=xmlHttp.responseXML;
				var resTagName=res.getElementsByTagName("message")[0];
				var message=resTagName.firstChild.data;
				var passed=xmlHttp.responseXML.getElementsByTagName("pass")[0].firstChild.data;
				if(passed=="true"){
					colorfont="blue";
				}
				document.getElementById("userMsg").innerHTML="<font color="+colorfont+">"+message+"</font>";
			}
		}
	}
	function setMessage(passed,message){
		var colorfont="red";
		if(passed=="true"){
			colorfont="blue";
		}
		document.getElementById("userMsg").innerHTML="<font color="+colorfont+">"+message+"</font>";

	}
	function checkUserName(){
		var userName=document.getElementById("userName").value;
		if (userName==null||""==userName) {
			document.getElementById("userMsg").innerHTML="<font color=red>用户名不能为空</font>";
		}else{
			validate();
		}
	}
	<%--window.onload=function(){
		var department1=document.getElementById("department1");
		department1.action="ViewAllDepartmentServlet";
	}--%>
</script>
</head>
<body>
	<h1>员工注册信息</h1>
		<font color="red">${requestScope.msg}</font>
	<form id="form_2">
		姓名:<input type="text" name="name" value="${param.name}"><br>
		<div id="userMsg"></div>
		用户名:<input type="text" name="userName" id="userName" onblur="checkUserName()">
		<br>
		密码:<input type="password" name="psw" id="psw"><br>
		<div id="pswMsg"></div>
		确认密码:<input type="password" id="psw1" onblur="checkpsw()"><br>
		联系电话:<input type="text" name="phone" value="${param.phone}"><br>
		电子邮件:<input type="text" name="email" value="${param.email}"><br>
		所在部门:<select id="department1" name="department" >
			   <option selected>-请选择部门-</option>
			   <c:forEach var="dept" items="${requestScope.deptList}">
			   <option value="${dept.departmentName}">${dept.departmentName}</option>
			   </c:forEach>
			   </select><br>
		<input type="button" value="注册" onclick="registerEmp()">
		<input type="reset" value="重置">
	</form>
</body>
</html>