<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadGoodsImg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br><br><br>
  <%
 String id=request.getParameter("id");
   %>
  <div align="center">
  	请上传商品的图片:
  	<form action="<%=basePath %>servlet/UploadServlet?id=<%=id %>" enctype="multipart/form-data" method="post">
  		<input type="file" name="goodsImg"/><input type="submit" value="上传"/>
  	</form>
  </div>
  </body>
</html>
