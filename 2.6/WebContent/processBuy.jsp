<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ page import="java.util.*"%>
	<%
	//取出session范围的itemMap属性
	Map<String,Integer> itemMap = (Map<String,Integer>)session
		.getAttribute("itemMap");
	//如果Map对象为空，则初始化Map对象
	if (itemMap == null)
	{
		itemMap = new HashMap<String,Integer>();
		itemMap.put("姓名" , 0);
		itemMap.put("学号" , 0);
		itemMap.put("宿舍" , 0);
	}
	//获取上个页面的请求参数
	String[] buys = request.getParameterValues("item");
	//遍历数组的各元素
	for (String item : buys)
	{
		//如果item为book，表示选择购买书籍
		if(item.equals("name"))
		{
			int num1 = itemMap.get("姓名").intValue();
			//将书籍key对应的数量加1
			itemMap.put("姓名" , num1 + 1);
		}
		//如果item为computer，表示选择购买电脑
		else if (item.equals("id"))
		{
			int num2 = itemMap.get("学号").intValue();
			//将电脑key对应的数量加1
			itemMap.put("学号" , num2 + 1);
		}
		//如果item为car，表示选择购买汽车
		else if (item.equals("dorm"))
		{
			int num3 = itemMap.get("宿舍").intValue();
			//将汽车key对应的数量加1
			itemMap.put("宿舍" , num3 + 1);
		}
	}
	//将itemMap对象放到设置成session范围的itemMap属性
	session.setAttribute("itemMap" , itemMap);
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> 购买的物品列表 </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>


	您所点击的次数为：<br/>
	姓名：<%=itemMap.get("姓名")%>次<br/>
	学号：<%=itemMap.get("学号")%>次<br/>
	宿舍：<%=itemMap.get("宿舍")%>次
<p><a href="shop.jsp">再次点击</a></p>
</body>
</html>
