<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<!-- <center><h1>在线投票系统</h1></center>
		欢迎您，${sessionScope.sessionUser.username} -->
		<div class="col-sm-offset-3">
            <h1 class="col-sm-offset-3">在线投票网站</h1>
            <h2 class="col-sm-offset-8">欢迎您，${sessionScope.sessionUser.username} </h2>

            <form class="form-horizontal" action="searchvote.jsp" method="get">
                <div class="form-group">
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="search" id="search" placeholder="请输入关键字">
                    </div>
                </div>
                <div class="form-group">
                    <div class=" col-sm-2">
                        <button type="submit" class="btn btn btn-info">搜索</button>
                    </div>
                </div>
            </form>
            <a href="JSP/register.jsp" >注册</a>
            <a href="JSP/login.jsp" >登录</a>
           	<a href="JSP/addvote.jsp" >发起投票</a>
        </div>
    
  </body>
</html>
