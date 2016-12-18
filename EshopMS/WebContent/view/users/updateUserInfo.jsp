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
		User u=(User)session.getAttribute("usersInfo");
	 %>
	 <br><br><br>
	<form method="post" action="<%=basePath %>servlet/UpdateUserInfoServlet">
		<table cellpadding="3" width="70%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			<tr>
				<td colspan="4" align="center">修改会员密码</td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td>
					<input type="text" name="userName" size="30" value=<%=u.getUserName() %> disabled="disabled" style="background-color:transparent;border:0px" />
				</td>
				<td>性别:</td>
				<td>	
					<input type="text" name="userSex" size="30" value=<%=u.getUserSex() %> disabled="disabled" style="background-color:transparent;border:0px" />
				</td>
			<tr>
			
			<tr>
				<td>账号:</td>
				<td>
					<input type="text" name="userID" size="30" value=<%=u.getUserID() %> style="background-color:transparent;border:0px" />
				</td>
				<td>密码:</td>
				<td>
					<input type="text" name="password" size="30" value=<%=u.getPassword() %> style="background-color:transparent;border:0px" />
				</td>
			</tr>
			
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="修改密码" />
					<input type="button" value="返回" onclick="history.back()"/>
				</td>
			</tr>
				
		</table>
	</form>
</body>
</html>