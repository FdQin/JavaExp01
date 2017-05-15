<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="GBK" import="lee.Person,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>当前在线用户人数:${userNumber }<br/>
<% 
	request.setCharacterEncoding("GBK");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	
	ArrayList<Person> userList = (ArrayList<Person>)request
			.getServletContext().getAttribute("userList"); 
	
	if(userList!=null){
       for(int i = 0 ; i < userList.size() ; i++){
    	   Person p = userList.get(i);
    	   if(p.getName()==null){
        	   p.setId(Long.parseLong(id));
        	   p.setName(name);
    	   }

		   %>
		   	姓名：<%=p.getName() %><br/>
		   	学号：<%=p.getId() %><br/>
		    SessionId:<%=p.getSessionId() %> <br/>
		   <%
		}
    } 
	request.getServletContext().setAttribute("userList",userList); 
%>
</body>
</html>