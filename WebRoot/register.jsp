	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:52 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>注册</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<!-- 原CSS -->
<!-- <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css" rel="stylesheet"> -->
    
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<style type="text/css">
		.backlogin{
			margin-top: 20px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
		var flag = 0;
			$("#pwd2").keyup(function (e) {
			var pwd1 = $(this).val();
			var pwd2 = $("#pwd1").val();
		lastTime = e.timeStamp;
		setTimeout(function () {
		
		if (lastTime - e.timeStamp == 0) {
		/* //alert("进来了1");
			$.ajax({
				url:"LoginServlet",
				type:"get",
				data:{
				userid:$("#text").val()
				},
				success:function(data){
				//alert(data);
				var result=data.toString();
					if(result=="false"){
						$("#info").html("可以注册!");
						
					}
					if(result=="true"){
					//alert("进来了2");
						$("#info").html("用户名已存在！");
					}
				}
			}) */
			if(pwd1 != pwd2){
			$(".page-container form").find('.error').fadeOut('fast', function(){
                $(this).css('top', '165px');
            });
				 $(".page-container form").find('.error').fadeIn('fast');
				 flag=0;
				}
				else{
					flag=1;
				}
			}
		
		}, 300); 
	});
		 $(".page-container form").submit(function(){
		 		if(flag==1){
		 			return true;
		 		}else{
		 			return false;
		 		}
		 
		 })
		
		
});
	
	</script>
</head>

<body class="gray-bg">

    <div class=" page-container">
        <div>
           
            
            <h1>Register</h1>
            <form class="m-t" role="form" action="register" method="post">
                <!-- <div class="form-group"> -->
                    <input type="text" class="username" placeholder="请输入用户名"  name="userName">
             <!--    </div> -->
                <!-- <div class="form-group"> -->
                    <input type="password" class="password"  id="pwd1" placeholder="请输入密码"  name="userPassword">
               <!--  </div> -->
                <!-- <div class="form-group"> -->
                    <input type="password" class="  again" id="pwd2" placeholder="请再次输入密码" >
                <!-- </div> -->
              <!--   <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <input type="checkbox"><i></i> 我同意注册协议</label>
                    </div>
                </div> -->
                <button type="submit"  style="font-family: '微软雅黑' ;">注 册</button>
				<div class="error"><span>+</span></div>
				<div class="backlogin"><p >已经有账户了？<a href="index.jsp" style="text-decoration: none;color:yellow;">点此登录</a></div>
                
                </p>

            </form>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    
    <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
        <script src="js/registerscripts.js"></script>
    
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:52 GMT -->
</html>
