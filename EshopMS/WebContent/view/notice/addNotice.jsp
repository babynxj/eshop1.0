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
	<form method="post" action="<%=basePath %>servlet/AddNoticeServlet">
		<table cellpadding="3" width="70%" align="center" border="1"
			bordercolor="#99ccff" style="border-collapse:collapse">
			<tr>
				<td colspan="2" align="center">添加商城公告</td>
			</tr>
			<tr>
				<td>商城公告号:</td>
				<td>
					<input type="text" name="noticeID" size="30" style="background-color:transparent;border:0px" />
				</td>
			</tr>
			<tr>
				<td>商城公告内容:</td>
				<td>
					<input type="text" name="noticeContent" size="30" style="background-color:transparent;border:0px" />
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