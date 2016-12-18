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
	 <br><br><br>
	<form method="post" action="<%=basePath %>servlet/UserRegisterServlet">
		<table cellpadding="3" width="80%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			<tr>
				<td colspan="4" align="center">会员注册</td>
			</tr>
			
			<tr>
				<td>账号:</td>
				<td>
					<input type="text" name="userID" size="30" style="background-color:transparent;border:0px" />
				</td>
				<td>密码:</td>
				<td>
					<input type="text" name="password" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td>姓名:</td>
				<td>
					<input type="text" name="userName" size="30" style="background-color:transparent;border:0px" />
				</td>
				<td>性别:</td>
				<td>
					<input type="text" name="userSex" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td>邮寄地址:</td>
				<td>
					<input type="text" name="address" size="30" style="background-color:transparent;border:0px" />
				</td>
				<td>联系方式:</td>
				<td>
					<input type="tel" name="phone" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td>电子邮箱:</td>
				<td>
					<input type="email" name="email" size="30" style="background-color:transparent;border:0px" />
				</td>
				<td>邮编:</td>
				<td>
					<input type="text" name="postcode" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="注册" />
					<input type="button" value="返回" onclick="history.back()"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>