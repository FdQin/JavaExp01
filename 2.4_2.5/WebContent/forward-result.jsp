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
	<title>forward结果页</title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<!-- 使用request内置对象获取age参数的值 -->
	<%=request.getParameter("name")%>
	<!-- 输出username请求参数的值 -->
	<%=request.getParameter("id")%>
</body>
</html>