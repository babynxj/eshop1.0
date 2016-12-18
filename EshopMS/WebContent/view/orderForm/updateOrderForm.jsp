<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="com.bean.GoodsClass"%>
<%@page import="com.sun.swing.internal.plaf.basic.resources.basic"%>
<%@page import="com.bean.User"%>
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

</style>
</head>
<body>
	<%
		Vector v=(Vector)session.getAttribute("orderForm");
	 %>
	 <br> <br> <br>
	<form method="post" action="<%=basePath %>servlet/UpdateOrderFormServlet">
		<table cellpadding="3" width="90%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			
			<tr>
				<td>订单编号:</td> 
				<td>
					<input type="text" name="orderFormID" size="30" value=<%=v.elementAt(0) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>订货人:</td>
				<td>	
					<input type="text" name="userName" size="30" value=<%=v.elementAt(1) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>送货地址:</td>
				<td>	
					<input type="text" name="address" size="30" value=<%=v.elementAt(2) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td>	
					<input type="text" name="phone" size="30" value=<%=v.elementAt(3) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>订单状态:</td>
				<td>	
					<input type="text" name="isPayoff" size="30" value=<%=v.elementAt(4) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>付款状态:</td>
				<td>	
					<input type="text" name="isConsignmenet" size="30" value=<%=v.elementAt(5) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>邮政编码:</td>
				<td>	
					<input type="text" name="postcode" size="30" value=<%=v.elementAt(6) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>订单总价:</td>
				<td>	
					<input type="text" name="totalPrice" size="30" value=<%=v.elementAt(7) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="发货" />
				</td>
				<td>
					<input type="button" value="返回" onclick="history.back()"/>
				</td>
			</tr>
		</table>
	</form>
	
<%
	  ArrayList list=(ArrayList)session.getAttribute("orderList");
%>
	<table cellpadding="3" width="90%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
		<tr>
			<td >商品编号</td>
			<td>商品名</td>
			<td>单价</td>
			<td>数量</td>
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
		</tr>
	<%	
		 }
	 }
		%>
	</table>
	
</body>
</html>