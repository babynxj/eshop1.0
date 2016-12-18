<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="com.bean.GoodsClass"%>
<%@page import="com.sun.swing.internal.plaf.basic.resources.basic"%>
<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		Vector v=(Vector)session.getAttribute("goodsInfo");
		ArrayList<GoodsClass> list=(ArrayList<GoodsClass>)session.getAttribute("goodsClassName");
	 %>
	 <br> <br> <br>
	<form method="post" action="<%=basePath %>servlet/UpdateGoodsInfoServlet">
		<table cellpadding="3" width="90%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			
			<tr>
				<td>商品编号:</td> 
				<td>
					<input type="text" name="goodsID" size="30" value=<%=v.elementAt(0) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>商品名:</td>
				<td>	
					<input type="text" name="goodsName" size="30" value=<%=v.elementAt(1) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>单价:</td>
				<td>	
					<input type="text" name="goodsPrice" size="30" value=<%=v.elementAt(2) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>所属分类:</td>
				<td>	
					<input type="text" name="goodsClass" size="30" value=<%=v.elementAt(3) %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>修改商品分类:</td>
				<td>	
					<select name="goodsClassName">
						<%	
						if(list.size()>0&&list!=null){
							for(int i=0;i<list.size();i++){	
						%>
						<option value=<%=list.get(i).getGoodsClassName() %>><%=list.get(i).getGoodsClassName() %></option>
						<%
							}
						}
						 %>
					</select>
				</td>
			</tr>
			<tr>
				<td>商品简介:</td>
				<td>	
					<input type="text" name="goodsDepict" size="30" value=<%=v.elementAt(4) %> style="background-color:transparent;border:0px" />
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