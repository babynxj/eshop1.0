<%@page import="com.bean.Admin"%>
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
	#table{
		font-size: 13px;
	}
</style>
</head>
<body>
<%
	Admin a=(Admin)session.getAttribute("managerInfo");
 %>
<br><br><br>
 <form action="<%=basePath %>servlet/ChangePwdServlet">
	<table cellpadding="3" width="70%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
		<tr>
			<td colspan="2" align="center">管理员修改密码</td>
		</tr>
		<tr>
			<td>管理员账号:</td>
			<td>
				<input type="text" name="adminID" style="background-color:transparent;border:0px" value=<%=session.getAttribute("adminID") %> />
			</td>
		</tr>
		<tr>
			<td >原来密码:</td>
			<td>
				<input type="text" name="pwd" style="background-color:transparent;border:0px" value=<%=a.getPassword() %> />
			</td>
		</tr>
		<tr>
			<td>修改密码:</td>
			<td>
				<input type="password" name="password" size="22" style="background-color:transparent;border:0px" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="修改"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	<div>
	</div>
 </form>
</body>
</html>