
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" import="lee.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> Java Bean测试 </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>

	<jsp:useBean id="dao" class="lee.DbDao" scope="page">
		<jsp:setProperty name="dao" property="driver" value="com.mysql.jdbc.Driver"/>
		<jsp:setProperty name="dao" property="url" value="jdbc:mysql://localhost:3306/hibernate"/>
		<jsp:setProperty name="dao" property="username" value="root"/>
		<jsp:setProperty name="dao" property="pass" value="qw134679"/>
	</jsp:useBean>

	<%
		ResultSet rs = dao.query("select * from Person");
		while(rs.next()){
			%> 
				<tr>
					<td><%=rs.getString(1) %></td>
					<td><%=rs.getString(2) %></td>
				</tr>
			<%
		}
	%>

</body>
</html>


