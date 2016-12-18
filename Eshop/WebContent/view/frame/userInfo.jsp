<%@page import="com.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css"> 
	<script src="<%=basePath %>js/jquery-1.11.0.js" type="text/javascript"></script> 
	<style type="text/css">
		table{
			font-family: 隶书;
			font-size: 12px;
		}
	</style>
  </head>
  
  <body>
  <%
  	User u=(User)session.getAttribute("userInfo");
   %>
  <form action="" method="post">
   <dl id="tree"> 
        <dd> 
	        <dl> 
	           <dt>用户信息</dt> 
	           <dd> 
	           		<ul>
	           			<li>	
	           				<table>
	           					<tr>
	           						<td>账号:</td>
	           						<td><%=u.getUserID() %></td>
	           					</tr>
	           					<tr>
	           						<td>密码:</td>
	           						<td><%=u.getPassword() %></td>
	           					</tr>
	           					<tr>
	           						<td>姓名:</td>
	           						<td><%=u.getUserName() %></td>
	           					</tr>
	           					<tr>
	           						<td>性别:</td>
	           						<td><%=u.getUserSex() %></td>
	           					</tr>
	           					<tr>
	           						<td>邮寄地址:</td>
	           						<td><%=u.getAddress() %></td>
	           					</tr>
	           					<tr>
	           						<td>联系方式:</td>
	           						<td><%=u.getPhone() %></td>
	           					</tr>
	           					<tr>
	           						<td>电子邮箱:</td>
	           						<td><%=u.getEmail() %></td>
	           					</tr>
	           				</table>
	           			</li>
	           		</ul>
	           </dd> 
	        </dl> 
        </dd> 
   </dl> 
   </form>
  </body>
</html>
