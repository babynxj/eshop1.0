<%@page import="com.bean.Notice"%>
<%@page import="com.bean.GoodsClass"%>
<%@page import="com.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#idtext{
		border-top-width:0px;
		border-left-width:0px;
		font-size:9pt;
		background:nonetransparentscrollrepeat0%0%;
		border-bottom-width:0px;
		vertical-align:middle;
		height:1.2em;
		text-align:center;
		border-right-width:0px
	}
	
	#table{
		font-size: 13px;
	}
	
</style>
</head>
<body>

<%
	  ArrayList<Notice> list=(ArrayList<Notice>)session.getAttribute("notice");
	
%>
	<table border="1" cellpadding="10" id="table" width="90%" bordercolor="#99ccff" style="border-collapse:collapse">
		<tr>
			<td>全选/单选</td>
			<td >公告号</td>
			<td>公告内容</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
	<%
	if(list!=null&&list.size()>0){
		 for(int i=0;i<list.size();i++){
	%>
		<tr>
			<td><input type="checkbox"></td>
			<td><%=list.get(i).getNoticeID() %></td>
			<td><%=list.get(i).getNoticeContent() %></td>
			<td><img src="<%=basePath %>images/update.png" />
				<a href="<%=basePath %>servlet/GetNoticeByIdServlet?id=<%=list.get(i).getNoticeID() %>" target="mainFrame">修改</a>
			</td>
			<td><img src="<%=basePath %>images/delete.png" />
				<a href="<%=basePath %>servlet/DeleteNoticeServlet?id=<%=list.get(i).getNoticeID() %>" target="mainFrame">删除</a>
			</td>					
		</tr>
	<%	
		 }
	 }
		%>
	</table>
	<div>
	</div>
</body>
</html>