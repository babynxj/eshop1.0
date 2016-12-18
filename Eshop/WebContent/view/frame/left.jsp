<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.GoodsClass"%>
<%@page import="com.bean.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
	<script type="text/javascript">
        var popUpWin = 0;
        function PopUpWindow(URLStr, left, top, width, height, newWin, scrollbars) {
            if (typeof (newWin) == "undefined")
                newWin = false;

            if (typeof (left) == "undefined")
                left = 100;

            if (typeof (top) == "undefined")
                top = 0;

            if (typeof (width) == "undefined")
                width = 800;

            if (typeof (height) == "undefined")
                height = 760;

            if (newWin) {
                open(URLStr, '', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=' + scrollbars + ',resizable=yes,copyhistory=yes,width=' + width + ',height=' + height + ',left=' + left + ', top=' + top + ',screenX=' + left + ',screenY=' + top + '');
                return;
            }

            if (typeof (scrollbars) == "undefined") {
                scrollbars = 0;
            }

            if (popUpWin) {
                if (!popUpWin.closed) popUpWin.close();
            }
            popUpWin = open(URLStr, 'popUpWin', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=' + scrollbars + ',resizable=yes,copyhistory=yes,width=' + width + ',height=' + height + ',left=' + left + ', top=' + top + ',screenX=' + left + ',screenY=' + top + '');
            popUpWin.focus();
        }
        
        
        
      
    </script>

  </head>
  
  <body>
  
  <%
  	ArrayList<GoodsClass> list=(ArrayList<GoodsClass>)session.getAttribute("goodsClass");
   %>
   <dl id="tree"> 
        <dd> 
	        <dl> 
	           <dt>商品分类</dt> 
	           <dd> 
	           		<ul>
	           		<%
	           		if(list!=null&&list.size()>0){
	           			for(int i=0;i<list.size();i++){
	           		 %>
	           		 <li><a href="<%=basePath %>servlet/GetGoodsInfoServlet?id=<%=list.get(i).getGoodsClassID() %>" target="mainFrame"><%=list.get(i).getGoodsClassName() %></a></li>
	           		 <%
	           		 	}
	           		 }
	           		  %>
	           		<li>
	         		</li>
	         		</ul>
	           </dd> 
	        </dl> 
        </dd> 
   </dl> 
 
  </body>
</html>
