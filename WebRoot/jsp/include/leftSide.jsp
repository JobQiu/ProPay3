<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">Admin 管理</a></h1>
      <!-- Logo (221px wide) -->
      <a href=""><img id="logo" src="<%=basePath%>jsp/resources/images/logo.png" alt="admin 标签" /></a>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> 你好, <a href="#" title="Edit your profile">XXX管理员</a>,欢迎来到后台<br />
        <br />
        <a href="<%=basePath%>jsp/manager/index.jsp" title="View the Site">首页</a> | <a href="#" title="Sign Out">退出登录</a> </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="<%=basePath%>jsp/manager/index.jsp" class="nav-top-item no-submenu">
          <!-- Add the class "no-submenu" to menu items with no sub menu -->
          首页 </a> </li>
        <li> <a href="#" class="nav-top-item current">
          <!-- Add the class "current" to current menu item -->
          新闻中心 </a>
          <ul>
			<%
              String name = request.getParameter("msg");
				 %>
					<li>
						<%
					if("cateAdd".equals(name)){
					 %> <a class="current" href="<%=basePath%>jsp/manager/cateAdd.jsp">新增栏目</a>
						<%
					}else{
					 %> <a href="<%=basePath%>jsp/manager/cateAdd.jsp">新增栏目</a> <%
					 }
					  %>
					</li>

					<li>
						<%
						if("cateMg".equals(name)){
					 %> <a class="current" href="<%=basePath%>jsp/manager/cateMg.jsp">栏目管理</a>
						<%
						}else{
					 %> <a href="<%=basePath%>jsp/manager/cateMg.jsp">栏目管理</a> <%
					 }
					  %>
					</li>

					<li>
						<%
					if("newsAdd".equals(name)){
					 %> <a class="current" href="<%=basePath%>jsp/manager/newsAdd.jsp">新增文章</a>
						<%
						}else{
					 %> <a href="<%=basePath%>jsp/manager/newsAdd.jsp">新增文章</a> <%
					 }
					  %>
					</li>
					<li>
						<%
					if("newsMg".equals(name)){
					 %> <a class="current" href="<%=basePath%>jsp/manager/newsMg.jsp">文章管理</a>
						<%
						}else{
					 %> <a href="<%=basePath%>jsp/manager/newsMg.jsp">文章管理</a> <%
					 }
					  %>
            <!-- Add class "current" to sub menu items also
            <li><a href="#">Manage Comments</a></li>
            <li><a href="#">Manage Categories</a></li>
			 -->
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 系统管理 </a>
          <ul>
            <li><a href="#">系统配置</a></li>
            <li><a href="#">修改密码</a></li>
			<li><a href="#">数据更新</a></li>
          </ul>
        </li>
		<!--
        <li> <a href="#" class="nav-top-item"> Image Gallery </a>
          <ul>
            <li><a href="#">Upload Images</a></li>
            <li><a href="#">Manage Galleries</a></li>
            <li><a href="#">Manage Albums</a></li>
            <li><a href="#">Gallery Settings</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> Events Calendar </a>
          <ul>
            <li><a href="#">Calendar Overview</a></li>
            <li><a href="#">Add a new Event</a></li>
            <li><a href="#">Calendar Settings</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> Settings </a>
          <ul>
            <li><a href="#">General</a></li>
            <li><a href="#">Design</a></li>
            <li><a href="#">Your Profile</a></li>
            <li><a href="#">Users and Permissions</a></li>
          </ul>
        </li>
		-->
      </ul>
	  
    </div>
  </div>