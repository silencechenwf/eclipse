<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	a{
		color:red
	}
</style>
<title>登陆成功</title>
</head>
<body>
<h1>欢迎访问Cool-Meeting管理系统</h1>
欢迎您,${param.userName}
您第${applicationScope.counts}个访问者
<a href="">[修改密码]</a>
</body>
</html>