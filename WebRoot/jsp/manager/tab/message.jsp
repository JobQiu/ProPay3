<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>message</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="5; url=<%=basePath%>jsp/manager/tab/tab.jsp">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="<%=basePath%>jsp/resources/scripts/jquery-1.10.2.js"></script>
    <script type="text/javascript">
      var time = 5;
      $(function(){
        setInterval(countDown(), 1000);
      });
      function countDown(){
        time = time - 1;
        if(time >= 0){
          $("#count").html(time);
        }else{
          window.location.href="<%=basePath%>jsp/manager/tab/tab.jsp";
        }
      }
    </script>
  </head>
  
  <body onload="countDown()">
    <center>
        <h2>${message}</h2>
        <span id="count" style="color:red">5</span>秒后自动返回<br>
        <a href="<%=basePath%>jsp/manager/main?curPage=1" target="_top">返回</a>
    </center>
  </body>
</html>
