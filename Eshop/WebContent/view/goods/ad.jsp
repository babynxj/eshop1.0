<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ad.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/ad.css">

	<script src="<%=basePath %>js/jquery-1.11.0.js" type="text/javascript"></script>
	<script src="<%=basePath %>js/ad.js" type="text/javascript"></script>

  </head>
  
  <body>
  <div id="jnImageroll">
			<a href="#nogo" id="JS_imgWrap">
				<img src="<%=basePath %>images/ads/1.jpg" />
				<img src="<%=basePath %>images/ads/2.jpg" />
				<img src="<%=basePath %>images/ads/3.jpg" />
				<img src="<%=basePath %>images/ads/4.jpg" />
				<img src="<%=basePath %>images/ads/5.jpg" />
			</a>
			<div>
				<a href=""><em>淘好货</em><em>全场119元起</em></a>
				<a href=""><em>商城促销</em><em>全场357元起</em></a>
				<a href=""><em>网上商城</em><em>全场89元</em></a>
				<a href=""><em>新款上线</em><em>全场3.1折起</em></a>
				<a href="" class="last"><em>春季新品</em><em>全场4.1折起</em></a>
			</div>
		</div>
	
  </body>
</html>
