<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addTab</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>jsp/resources/scripts/jquery-1.10.2.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
      function esc(){
        window.opener.location.reload(true);
        window.close();
      }
    </script>
  </head>
  
  <body>
    <div><span style="color:red">${Addinfo}</span></div>
    <form name="form1" action="<%=basePath%>jsp/manager/tab/addTab">
      <table>
        <tr>
          <th width="3%" height="22" background="<%=basePath%>jsp/manager/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></th>
          <th width="12%" height="22" background="<%=basePath%>jsp/manager/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">接收号码</span></div></th>
          <th width="14%" height="22" background="<%=basePath%>jsp/manager/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">发送时间</span></div></th>
          <th width="18%" background="<%=basePath%>jsp/manager/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">邮件地址</span></div></th>
          <th width="23%" height="22" background="<%=basePath%>jsp/manager/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">内容</span></div></th>
        </tr>
        <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1"><input name="number" type="text" />
              <div align="center">  </div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><input name="phone" type="text" /></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><input name="time" type="text" /></span></div></td>
            <td bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><input name="email" type="text" /></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><input name="content" type="text" /></span></div></td>
        </tr>
      </table>
      <input type="submit" value="确定"/> <input type="button" value="退出" onclick="esc()"/>
    </form>
    
  </body>
</html>
