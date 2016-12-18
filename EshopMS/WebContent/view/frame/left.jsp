<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/treeview.css"> 
	<script src="<%=basePath %>js/jquery-1.11.0.js" type="text/javascript"></script> 
	<script type="text/javascript"> 
	  /* $(document).ready(function(){ 
	        $("#tree>dd>dl>dd").show(); 
	        $.each($("#tree>dd>dl>dt"), function(){ 
			$(this).click(function(){ 
			$("#tree>dd>dl>dd ").not($(this).next()).slideUp(); 
			$(this).next().slideToggle(500); 
	   }); 
	   }); 
	  });*/ 
	</script> 

  </head>
  
  <body>
   <dl id="tree"> 
        <dd> 
        <dl> 
           <dt>商品管理</dt> 
           <dd> 
             <ul> 
                <li><a href="<%=basePath %>servlet/GetGoodsClassServlet" target="mainFrame">商品上架</a></li> 
                <li><a href="<%=basePath %>servlet/GetGoodsInfoServlet" target="mainFrame">维护商品信息</a></li> 
             </ul> 
           </dd> 
        </dl> 
        <dl> 
           <dt>商品分类管理</dt> 
           <dd> 
              <ul> 
                <li><a href="<%=basePath %>view/goodsClass/addGoodsClass.jsp" target="mainFrame">添加分类</a></li> 
                <li><a href="<%=basePath %>servlet/GetGoodsClassInfoServlet" target="mainFrame">维护分类信息</a></li> 
              </ul> 
           </dd> 
        </dl> 
        <dl> 
           <dt>订单管理</dt> 
           <dd> 
              <ul> 
                 <li><a href="<%=basePath %>servlet/GetOrderFormServlet" target="mainFrame">维护订单信息</a></li> 
              </ul> 
           </dd> 
        </dl> 
        <dl> 
           <dt>会员管理</dt> 
           <dd> 
              <ul> 
              	<li><a href="<%=basePath %>servlet/GetUsersInfoServlet" target="mainFrame">维护会员信息</a></li>
              </ul> 
           </dd> 
        </dl> 
        <dl> 
           <dt>商城公告管理</dt> 
           <dd> 
              <ul> 
                 <li><a href="<%=basePath %>view/notice/addNotice.jsp" target="mainFrame">添加商城公告</a></li>
                 <li><a href="<%=basePath %>servlet/GetNoticeServlet" target="mainFrame">维护商城公告</a></li>
              </ul> 
           </dd> 
        </dl> 
        <dl> 
           <dt>管理员管理</dt> 
           <dd> 
              <ul> 
                 <li><a href="<%=basePath %>servlet/GetPasswordServlet" target="mainFrame">修改密码</a></li>
                 <li><a href="<%=basePath %>servlet/GetManagerInfoServlet" target="mainFrame">管理员个人信息</a></li>
              </ul> 
        </dd> 
        </dl> 
        </dd> 
   </dl> 
  </body>
</html>
