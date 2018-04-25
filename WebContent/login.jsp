<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
	function login() {
		var userName = document.getElementById("userName").value;
		var psw = document.getElementById("psw").value;
		if (userName == null || "" == userName) {
			var nameMsn = document.getElementById("nameMsn");
			nameMsn.innerHTML = "<font color=red>用户名不能为空</font>";
		}
		if (psw == null || "" == psw) {
			var pswMsn = document.getElementById("pswMsn");
			pswMsn.innerHTML = "<font color=red>密码不能为空</font>";
		}
		if (psw != null && "" != psw && userName != null && userName != "") {
			form_1.action = "LoginServlet";
			form_1.submit();
		}
	}
	function back(){
		form_1.action = "login.jsp";
		form_1.submit();
	}
	function register(){
		form_1.action="ViewAllDepartmentServlet";
		form_1.submit();
	}
</script>
</head>
<body>
	<h1>员工注册信息</h1>
	<font color="red">${requestScope.msg}</font>
	<form id="form_1">
		用户名:<input type="text" name="userName" id="userName" value="${param.userName}" ><br>
		<div id="nameMsn"></div>
		密码:<input type="password" name="psw" id="psw"><br>
		<div id="pswMsn"></div>
		<select name="selectTime">
			<option value="0">不保存</option>
			<option value="1">1天</option>
			<option value="7">7天</option>
			</select><br>
		<input type="button" value="登录" onclick="login()">
		<input type="button" value="返回" onclick="back()">
		<input type="button" value="注册" onclick="register()">
	</form>
	<%String userNameValue=null;
	  String pswValue=null;
	  String selectTimeValue=null;
	  Cookie[]cookies=request.getCookies();
	  if(cookies!=null){
		  for(Cookie cookie:cookies){
			  if(cookie.getName().equals("userName")){
				  userNameValue=cookie.getValue();
			  }
			  if(cookie.getName().equals("psw")){
				  pswValue=cookie.getValue();
			  }
			 
		  }
		  if(userNameValue!=null&&pswValue!=null){
			  request.getRequestDispatcher("LoginServlet?userName="+userNameValue+"&psw="+pswValue+"&selectTime="+selectTimeValue).forward(request, response);
		  }
	  }
	%>
</body>
</html>