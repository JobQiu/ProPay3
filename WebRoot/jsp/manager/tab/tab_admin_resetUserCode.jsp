<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="<%=basePath%>jsp/resources/scripts/jquery-1.10.2.js"></script>
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
function edit(){
	$(".edit")[0].innerText = $(".edit")[0].innerText;
	$(".STYLE1 div").hide();
	$(".edit").show();
}

var basePath = '<%=basePath%>jsp/';
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

$(function(){

  $("#checkAll").click(function(){
    var result1 = $(this).is(":checked");
    $(".che").prop("checked",result1);
  });

  $(".che").click(function(){
    var flag = $(this).is(":checked");
    var result = true;
    $(".che").each(function(){
      var temp = $(this).is(":checked");
      if(temp != flag){
        result = false;
        return false;
      }
    });
    if(result){
      $("#checkAll").prop("checked",flag);
    }else{
      $("#checkAll").prop("checked",false);
    }
  });

  $("#delAll").click(function(){
    confirm("确定要删除吗？");
    var ids = "";
    $(".che").each(function(){
      var temp = $(this).is(":checked");
      if(temp){
      var id = $(this).val();
      $(this).parent().parent().parent().remove();
      ids += "," + id;
      }
    });
    var number = ids.substring(1);
    $.post(basePath + 'manager/del',{number:number});
  });
  $("a[title=del]").click(function(){
    var id = $(this).attr("name");
    $(this).parent().parent().parent().parent().remove();
    $.post(basePath + 'manager/del',{number:id});
    //window.location.reload();
    });

  $("a[title=edit]").click(function(){
    var number = $(this).attr("name");
    window.open(basePath + "manager/tab/editTab.jsp?number=" + number,"Sample","fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=900,height=140,left=200,top=300");
  });


});

 function openwindow(){
    window.open(basePath + "manager/tab/addTab.jsp","Sample","fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=800,height=140,left=200,top=300");
 }


</script>

</head>

<body>
<form action="<%=basePath%>admin/showUsers">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=basePath%>jsp/manager/tab/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath%>jsp/manager/tab/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="<%=basePath%>jsp/manager/tab/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[用户管理]-[重置用户密码]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      </div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                     </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                     </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr id="delAll" >
                    </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath%>jsp/manager/tab/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath%>jsp/manager/tab/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
		  </tr>
        </table></td>
        <td width="8" background="<%=basePath%>jsp/manager/tab/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>

</table>
<table>
  <tr>
<td>
  用户名：</td>
<td> <input type= "text" name="username"></td>
</tr>

  <tr>
<td>
  账户：</td>
<td> <input type= "text" name="username"></td>
</tr>

  <tr>
<td>
  用户名：</td>
<td> <input type= "text" name="username"></td>
</tr>
</table>
<input type="hidden" name="key" value="${sessionScope.splitPage.key}" />
</form>

</body>
</html>
