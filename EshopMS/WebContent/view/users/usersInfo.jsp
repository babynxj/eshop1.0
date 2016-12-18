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
	
	#search{
		background: url(<%=basePath %>image/button.png);
	}
</style>
</head>
<body>

<%
	  ArrayList<User> list=(ArrayList<User>)session.getAttribute("usersInfo");
	
%>
<form action="<%=basePath %>/servlet/SearchUserInfoByIdServlet" method="post">
<font size="2">请输入会员账号:</font>
<input type="text" name="id"/><input type="submit" value="查询" />
</form>
	<table border="1" cellpadding="10" id="table" width="90%" bordercolor="#99ccff" style="border-collapse:collapse">
		<tr>
			<td>全选/单选</td>
			<td >会员卡号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>密码</td>
			<td>邮寄地址</td>
			<td>手机号码</td>
			<td>电子邮件</td>
			<td>注册时间</td>
			<td>邮编</td>
			<td>修改密码</td>
			<td>删除</td>
		</tr>
	<%
	if(list!=null&&list.size()>0){
		 for(int i=0;i<list.size();i++){
	%>
		<tr>
			<td><input type="checkbox"></td>
			<td><%=list.get(i).getUserID() %></td>
			<td><%=list.get(i).getUserName() %></td>
			<td><%=list.get(i).getUserSex() %></td>
			<td><%=list.get(i).getPassword() %></td>
			<td><%=list.get(i).getAddress() %></td>
			<td><%=list.get(i).getPhone() %></td>
			<td><%=list.get(i).getEmial() %></td>
			<td><%=list.get(i).getRegTime() %></td>
			<td><%=list.get(i).getPostcode() %></td>
			<td><img src="<%=basePath %>images/password.png" />
				<a href="<%=basePath %>servlet/GetUserInfoByIDServlet?id=<%=list.get(i).getUserID() %>" target="mainFrame">修改</a>
			</td>
			<td><img src="<%=basePath %>images/delete.png" />
				<a href="<%=basePath %>servlet/DeleteUserInfoServlet?id=<%=list.get(i).getUserID() %>" target="mainFrame">删除</a>
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