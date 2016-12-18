<%@page import="java.util.Vector"%>
<%@page import="com.bean.OrderForm"%>
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
	  ArrayList list=(ArrayList)session.getAttribute("shoppingCarInfo");
%>
	<img alt="" src="<%=basePath %>images/myShoppingCar.png" /><font color="#99ccff" >我的购物车</font>
	<table border="1" cellpadding="10" id="table" width="90%" bordercolor="#99ccff" style="border-collapse:collapse">
		<tr>
			<td >订单编号</td>
			<td>商品名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>金额</td>
			<td>删除</td>
		</tr>
	<%
	if(list!=null&&list.size()>0){
		 for(int i=0;i<list.size();i++){
	%>
		<tr>
			<td><%=((Vector)list.get(i)).elementAt(0) %></td>
			<td><%=((Vector)list.get(i)).elementAt(1) %></td>
			<td><%=((Vector)list.get(i)).elementAt(2) %></td>
			<td><%=((Vector)list.get(i)).elementAt(3) %></td>
			<td><%=((Vector)list.get(i)).elementAt(4) %></td>
			<td><img src="<%=basePath %>images/delete.png" />
				<a href="<%=basePath %>servlet/DeleteOrderFormInfoServlet?id=<%=((Vector)list.get(i)).elementAt(0) %>" target="mainFrame">删除</a>
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