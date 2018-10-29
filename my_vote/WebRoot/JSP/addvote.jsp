<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投票发起页</title>
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
    <%
    if(session.getAttribute("sessionUser")==null){
		 request.setAttribute("msg", "请先登录！");
		 request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
		 return;
  }
  %>
  
  <body>
  		<div class="col-sm-offset-3">
            <h1 class="col-sm-offset-3">在线投票网站</h1>
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
        <br>
     	<div class="container">
            <br> 
            <form class="form-horizontal" action="NewvoteServlet" method="post">
                <div class="form-group">
                    <label for="vote_name" class="col-sm-2 control-label">投票主题</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="vname" id="vname" placeholder="例：S8你最看好哪支队伍？">
                    </div>
                </div>
                <div class="form-group">
                    <label for="vote_choice" class="col-sm-2 control-label">投票选项数</label>
                    <div class="col-sm-8">
                        <input type="number" class="form-control" name="vchoice" id="vchoice" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="vote_type" class="col-sm-2 control-label">投票类型</label>
                    <div class="col-sm-8">
                        <input type="number" min="0" max="1" class="form-control" name="vtype" id="vtype" placeholder="0为单选，1为多选">
                    </div>
                </div>
                <div class="form-group">
                    <label for="vote_deadline" class="col-sm-2 control-label">投票截至日期</label>
                    <div class="col-sm-8">
                        <input type="date" class="form-control" name="deadline" id="deadline">
                    </div>
                </div>
               			<input type="hidden"  name="uid" value="${sessionUser.uid }">
                <div class="form-group">
                    <div class="col-sm-offset-10 col-sm-10">
                        <button type="submit" class="btn btn btn-info" >下一步</button>
                    </div>
                </div>
            </form>
        </div>
  </body>
</html>
