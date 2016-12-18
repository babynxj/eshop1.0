<%@page import="com.bean.Notice"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'right.jsp' starting page</title>
    
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
    	ul.scrollline{height:90px;}//定义滚动列表的高度
  	</style>
    <script language="javascript">
    $(function(){
    	var area=$('ul.scrollline');//取得滚动区域
    	var timespan=1000;        //定义滚动时间间隔
    	var timeID;                     //需要清除的动画
    	area.hover(function(){//自定义鼠标悬停与移出事件处理
    			clearInterval(timeID);//当鼠标在滚动区域中时停止滚动，移出事件处理
    		},function(){//鼠标悬停事件处理
    			timeID=setInterval(function(){//设置滚动时间间隔及滚动动作
    				var moveline=area.find('li:first');//获取列表当前第一行
    				var lineheight=moveline.height();//取得每次滚动高度
					//通过取负margin值，隐藏第一行
    				moveline.animate({marginTop:-lineheight+'px'},600,function(){
					//隐藏后，将该行的margin值置零，并添加到列表尾部，实现循环滚动
    					moveline.css('marginTop',0).appendTo(area);
    					})
    				},timespan)//滚动间隔时间取决于timespan
    		}).trigger('mouseleave');//函数载入时，模拟执行mousemove，即自动滚动
    });
    </script>
  </head>
  
  <body>
  
  <%
  	ArrayList<Notice> list=(ArrayList<Notice>)session.getAttribute("notice");
   %>
   <dl id="tree">  
        <dd> 
        <dl> 
           <dt>商城公告</dt> 
           <dd> 
			    <ul class="scrollline">
			      <%
			    	if(list!=null&&list.size()>0){
			    		for(int i=0;i<list.size();i++){
			     %>
			     		<li><%=list.get(i).getNoticeContent() %></li>
			     <%
			     		}
			     	}
			      %>
			    </ul>
           </dd> 
        </dl> 
        </dd> 
   </dl> 
  </body>
</html>
