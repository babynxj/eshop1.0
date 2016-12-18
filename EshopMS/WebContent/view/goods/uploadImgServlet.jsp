<%@page import="java.sql.Date"%>
<%@page import="com.jspsmart.upload.File"%>
<%@ page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addGoodsInfoServlet.jsp' starting page</title>
    
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
  		<%!
  			String extname;
  		 %>
  
  		<%
			SmartUpload su = new SmartUpload();
			su.initialize(pageContext); // 初始化上传操作
			su.setAllowedFilesList("jpg,gif,png,jpeg,bmp");//允许上传的文件通过扩展名限制。
			su.upload();//上传文件
			
			File myFile = su.getFiles().getFile(0);//获取上传地址
			if (!myFile.isMissing()) {//路径存在
				//extname = myFile.getFileExt();//获取文件主路径
				String fileName = su.getFiles().getFile(0).getFileName();// 产生一个唯一的文件名
				myFile.saveAs(fileName,su.SAVE_PHYSICAL);//更换路径重命名
				
			}
			//su.save("/upload");//upload文件夹另存到weblogic部署的项目文件夹中
			String goodsImg=application.getRealPath("/")+"/upload/" + su.getFiles().getFile(0).getFileName();
		%>
		<jsp:forward page="/servlet/GetGoodsClassServlet"></jsp:forward>
	
  </body>
</html>
