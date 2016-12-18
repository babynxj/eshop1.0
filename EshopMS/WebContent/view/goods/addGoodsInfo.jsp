<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@page import="com.bean.GoodsClass"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<GoodsClass> list=(ArrayList<GoodsClass>)session.getAttribute("goodsClassName");
		
	 %>
	<br><br><br>
	<form method="post" action="<%=basePath %>servlet/AddGoodsInfoServlet" >
		<table cellpadding="3" width="70%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			<tr>
				<td colspan="2" align="center">添加商品</td>
			</tr>
			<tr>
				<td>商品编号:</td>
				<td>
					<input type="text" name="goodsID" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>商品名:</td>
				<td>
					<input type="text" name="goodsName" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>单价:</td>
				<td>
					<input type="text" name="goodsPrice" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>所属分类:</td>
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
				<td>数量:</td>
				<td>
					<input type="text" name="goodsAmount" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>生产厂家:</td>
				<td>
					<input type="text" name="manufacturer" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>商品简介:</td>
				<td>
					<input type="text" name="goodsDepict" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" name="add" value="新增" /> <input type="button" value="返回" onclick="history.back()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>