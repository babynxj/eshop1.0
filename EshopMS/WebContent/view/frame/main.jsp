<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<frameset rows="180,*,33"  bordercolor="#1873aa"  scrolling="No" noresize="noresize"  frameborder="no"
		border="0" framespacing="0">
	<frame src="<%=basePath%>view/frame/top.jsp" name="topFrame" scrolling="No"  noresize="noresize" id="topFrame" />
	<frameset cols="230,*">
		<frame src="<%=basePath%>view/frame/left.jsp"   noresize="noresize" name="leftFrame" />
		<frame src="<%=basePath %>/servlet/GetManagerInfoServlet"  name="mainFrame"/>
	</frameset>
	<frame src="<%=basePath%>view/frame/down.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
</html>
