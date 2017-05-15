<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2016, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>application测试</title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
	<%
	String driver = application.getInitParameter("driver");
	String url = application.getInitParameter("url");
	String user = application.getInitParameter("user");
	String pass = application.getInitParameter("pass");
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,user,pass);
	//创建Statement对象
	Statement stmt = conn.createStatement();
	//执行查询
	ResultSet rs = stmt.executeQuery("select * from Person");
	%>
<table bgcolor="#9999dd" border="1" width="480">
	<%
	//遍历结果集
	while(rs.next())
	{
	%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
		</tr>
	<%
	}
	%>
<table>
</body>
</html>