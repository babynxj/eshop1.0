<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上商城后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	<!--
	
		body{
			text-align: center;
			background-repeat: no-repeat;
		
		}
		
		#div{
			width: 600px;
			height:600px;
		}
		
		#loginDiv{
			width: 100px;
			height:100px;
			margin: 0 auto;	
			width: 60%;
			height: 40%;
			background: #CCC;
			filter: alpha(opacity=50);
			-khtml-opacity: 0.5;
			-moz-opacity: 0.5;
			opacity: 0.5;
			position: absolute;
			top: 140;
			left: 450;
		}
		
		#loginBtn{
			background-image: url('<%=basePath%>/images/login.png');
			height:27px;
			width:92px;
			border: 0px;
		}
	-->
	</style>
  
  
  <script type="text/javascript">
  	function refresh(){
  		document.getElementById("authImg").src="authImg.jsp?now="+new Date();
  	}
  </script>
  
  </head>
  <body background="images/bg.png">
  	<div id="div">
  	<div id="loginDiv">
  	<form action="<%=basePath %>servlet/LoginCheckServlet" method="post">
  		<br> 
  	    <h3><font size="3" color="#0066ff">网上商城后台管理系统</font></h3>
  	    <table border="0">
  		<tr><td><font color="#0066ff">账号:</font></td><td><input type="text" name="account" size="18"/></td></tr>
  	    <tr><td><font color="#0066ff">密 码 :</font></td><td><input type="password" errmsg="密码不能为空!" name="password"/></td>
  		<tr><td><font color="#0066ff">验证码:</font></td><td><input type="text" name="authCode" size="18"/></td></tr>
  		<tr><td><img src="authImg.jsp" id="authImg"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  		<td><font size="2"><a href="#"onclick="refresh()">看不清楚?换一张</a></font></td></tr>
  		<tr><td colspan="2"><input type="submit" value="" id="loginBtn" /></td></tr>
  		</table>
  	<%
  		String errorType=(String)session.getAttribute("errorType");
  		if(errorType!=null){
  			out.println("<font color='red'>"+errorType+"</font>");
  			
  		}
  	 %>	
  	</form>
  	
  	</div>
  	</div>
  
  </body>
</html>
