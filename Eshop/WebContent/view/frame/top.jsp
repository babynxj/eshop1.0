<%@page import="com.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
			img{
				width:1270px;
				height:130px;
				border-radius:5px;
			}
		
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="<%=basePath %>css/navmenu.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <%
  User u=(User)session.getAttribute("userInfo");
   %>
  
	 <img alt="" src="<%=basePath %>images/title_bg.jpg"/>
<div id="navmenu" >
	<ul class="menu">
		<li><a href="<%=basePath %>view/goods/ad.jsp"  target="mainFrame">首页</a></li>
		<li><a href=""  target="mainFrame">论坛</a></li>
		<%
			if(u!=null){
		%>
			<li><a href="<%=basePath %>servlet/OrderFormServlet?id=<%=u.getUserID() %>"  target="mainFrame">我的购物车</a></li>
		<%
			}
		%>
		<li><a href=""  target="mainFrame">资源共享</a></li>
		<li><a href=""  target="mainFrame">文章归档</a></li>
		<li><a href=""  target="mainFrame">关于我</a></li>
		<li><a href=""  target="mainFrame">留言本</a></li>
	</ul>
</div>

	 <div align="right">
	 <font size="2" color="red">你还没登录&nbsp;&nbsp;<a href="">注册?</a></font>
	 </div>
  </body>
</html>
