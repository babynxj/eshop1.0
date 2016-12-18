<%@page import="com.bean.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
			*{margin:0;padding:0;}
			a,img{border:0;text-decoration:none;}
			body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
			/* p_number */
			.p_number{border:solid 1px #ddd;padding:10px 0 0 10px;width:400px;height:80px;margin:40px auto;}	
		</style>

</head>
  
  <body>
  	<%
  		ArrayList<Goods> list=(ArrayList<Goods>)session.getAttribute("goodsInfo");
  	 %>
  	 <%
  	 	if(list.size()>0&&list!=null){
  	 		for(int i=0;i<list.size();i++){
  	  %>
  	  <div class="p_number">
  	  	<img alt="" src="<%=getServletContext().getRealPath("/")+list.get(i).getGoodsImg() %>"><br>
  	  	<input type="text" value=<%=list.get(i).getGoodsName() %> style="background-color:transparent;border:0px" /><br>
  	  	约¥<input type="text" value=<%=list.get(i).getGoodsPrice() %> style="background-color:transparent;border:0px" /><br>
  	  	<img alt="" src="<%=basePath %>images/depict.png"><a href="<%=basePath %>servlet/GetGoodsInfoByIdServlet?id=<%=list.get(i).getGoodsID() %>" target="mainFrame">详情</a>
  	  	<img alt="" src="<%=basePath %>images/shoppingCar.png"><a href="<%=basePath %>servlet/GetGoodsInfoByIdServlet?id=<%=list.get(i).getGoodsID() %>" target="mainFrame">购买</a>
  	  </div>
	<%
			}
		}
	%>
  </body>
</html>
