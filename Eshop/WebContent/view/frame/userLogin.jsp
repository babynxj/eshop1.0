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
  <form action="<%=basePath %>servlet/GetUserInfoByIdServlet" method="post">
   <dl id="tree"> 
        <dd> 
	        <dl> 
	           <dt>用户登录</dt> 
	           <dd> 
	           		<ul>
	           			<li>	
	           				<br>
	           				<table>
	           					<tr>
	           						<td>账号:</td>
	           						<td><input type="text" name="userID" size="18"/></td>
	           					</tr>
	           					<tr>
	           						<td>密码:</td>
	           						<td><input type="password" size="20" name="password"/></td>
	           					</tr>
	           					<tr>
	           						<td></td>
	           						<td>
	           							<input type="submit" value="登录"/>
	           							<input type="reset" value="重置"/>
	           						</td>
	           					</tr>
	           					<tr>
	           						<td></td>
	           						<td>
	           							<a href="<%=basePath %>view/users/userRegister.jsp" target="mainFrame">还没账号?注册</a>
	           						</td>
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
