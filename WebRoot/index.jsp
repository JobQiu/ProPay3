<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>欢迎使用个人资金管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="login" method="post">
                <input type="text" name="adminName" class="username" placeholder="请输入用户名" value="${username }">
                <input type="password" name="adminPassword" class="password" placeholder="请输入密码">
                <button type="submit" >登录</button>
                <button type="button" style="background: #FFF68F; border: #FFF68F ;color:red" onclick="signup()" >注册</button>
                <input  class="power"  type="radio" name="power"  value="admin"/>&nbsp<span class="check">管理员</span>
                <input class="power" type="radio" name="power"  value="counter"  checked="checked"/>&nbsp<span class="check">用户</span>
                <input class="power" type="checkbox" name="remember" value="remenber" />&nbsp<span class="check">記住密碼</span>
                <span class="check"><a href="" style="text-decoration: none; color:yellow;">忘記密碼</a></span>
                <div class="error"><span>+</span></div>
            </form>
            <!-- <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div> -->
       <!--  </div>
        <div align="center">Collect from <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></div> -->

        <!-- Javascript -->
        <script src="js/jquery-1.8.2.min.js"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
        <script src="js/scripts.js"></script>
		<script type="text/javascript">
			
				function signup(){
					location.href="register.jsp";
				}
			
		</script>
    </body>

</html>