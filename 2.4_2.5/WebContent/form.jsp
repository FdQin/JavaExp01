<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2016, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> 提交 </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
<!-- 表单提交页面 -->
<form id="login" method="post" action="jsp-forward.jsp">
	姓名:<input type="text" name="name"><br/>
	学号:<input type="text" name="id">
	<input type="submit" value="login">
</form>
</body>
</html>