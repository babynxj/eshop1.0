<%@page import="com.bean.User"%>
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
	<script type="text/javascript" src="<%=basePath %>js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/payfor.js"></script>
	<style type="text/css">
*{margin:0;padding:0;}
a,img{border:0;text-decoration:none;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
/* p_number */
.p_number{border:solid 1px #ddd;padding:10px 0 0 10px;width:480px;height:80px;margin:40px auto;}	
.p_number .f_l{float:left;}
.p_number .add_chose{width:105px;}
.p_number .add_chose a{float:left;margin:5px 0 0 0;display:block;width:15px;height:15px;line-height:99em;overflow:hidden;background:url(<%=basePath %>images/reduce-add.gif) no-repeat;}
.p_number .add_chose a.reduce{background-position:0 0;}
.p_number .add_chose a.reduce:hover{background-position:0 -16px;}
.p_number .add_chose a.add{background-position:-16px 0;}
.p_number .add_chose a.add:hover{background-position: -16px;}
.p_number .add_chose .text{float:left;margin:0 5px;display:inline;border:solid 1px #ccc;padding:4px 3px 4px 8px;width:40px;line-height:18px;font-size:14px;color:#990000;font-weight:800;}
.p_number .buy{line-height:2em;}
.p_number .buy .total-font{font-family:Arial;font-size:26px;}
.p_number .buy .jifen{margin-left:20px;color:#ACACAC;}
.p_number .buy .jifen b{margin:0 3px;}
</style>

  </head>
  
  <body>
  	<form action="<%=basePath %>servlet/AddToShoppingCarServlet" method="post">
  	<%
  		User u=(User)session.getAttribute("userInfo");
  	 %>
  
  
  	<%
  		Goods goods=(Goods)session.getAttribute("goodsInfo");
  	 %>
  	  	
  	  	<div class="p_number">
  	  	 	<%
  	  		if(u!=null){
  	  	   %>
  	  	      <input type="hidden" name="userID" value=<%=u.getUserID() %> style="background-color:transparent;border:0px"  />
  	  	   <%
  	  		}
  	  	   %>
  	  	
  	  	<img alt="" src="<%=getServletContext().getRealPath("/")+goods.getGoodsImg() %>"><br>
  	  	
  	  	<%=goods.getGoodsName() %><br>
  	  	<font color="red">库存:<%=goods.getGoodsLeaveNum() %></font><br>
  	  	<font>生产厂家:<%=goods.getManufacturer() %></font><br>
  	  	描述:<%=goods.getGoodsDepict() %><br>
		<!-- ￥ -->
		<div style="height:36px;font-size:16px;">商品单价：
		<strong id="price_item_1">
		$<%=goods.getGoodsPrice() %>
		<input type="hidden" value=<%=goods.getGoodsPrice() %> name="price"  style="background-color:transparent;border:0px" />
		  <input type="hidden" value=<%=goods.getGoodsID() %> name="goodsID"  style="background-color:transparent;border:0px" />
		</strong></div>
		
		<div class="f_l add_chose">
			<a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">
			-</a>
			<input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
			<a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">
			+</a>
		</div>
		
		<div class="f_l buy">
			总价：<span class="total-font" id="total_item_1"  ><%=goods.getGoodsPrice() %></span>
			<input type="hidden" name="total_price" id="total_price" value="" />
			<span class="jifen">购买商品可获得：<b id="total_points">18</b>积分</span>
		</div>
	
	</div>
  	  	<img alt="" src="<%=basePath %>images/shoppingCar.png">
  	  	<input type="submit" value="添加到购物车"/>
  	  	<img alt="" src="<%=basePath %>images/return.png">
  	  	<input type="button" onclick="history.back()" value="返回"/>
  	  	<br>
  </form>
  </body>
</html>
