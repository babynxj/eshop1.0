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
		GoodsClass g=(GoodsClass)session.getAttribute("goodsClassInfo");
	 %>
	 <br> <br> <br>
	<form method="post" action="<%=basePath %>servlet/UpdateGoodsClassServlet">
		<table cellpadding="3" width="90%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			<tr>
				<td>商品种类号:</td> 
				<td>
					<input type="text" name="goodsClassID" size="30" value=<%=g.getGoodsClassID() %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>商品种类名:</td>
				<td>	
					<input type="text" name="goodsClassName" size="30" value=<%=g.getGoodsClassName() %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="修改" />
				</td>
				<td>
					<input type="button" value="返回" onclick="history.back()"/>
				</td>
			</tr>
				
		</table>
	</form>
</body>
</html>