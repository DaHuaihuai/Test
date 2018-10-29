<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
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
    <div class="container">
            <br>
            <div class=" col-sm-offset-2"><a href="JSP/index.jsp">返回首页</a> </div>
            <br>
            <p style="color: red ; font-weight: 600">${msg }</p>
            <form class="form-horizontal" action="${pageContext.request.contextPath}/TestServlet" method="post">
            
            <!-- 通过继承BaseServlet的servlet来调用方法 -->
            <!-- <input type="hidden" name="method" value="test"> --> 
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                        ${errors.username }
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                        ${errors.password }
                    </div>
                </div>
                <div class="form-group">
                    <label for="datetime" class="col-sm-2 control-label">截止日期</label>
                    <div class="col-sm-8">
                        <input type="datetime-local" class="form-control" name="datetime-local" id="date" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="datetime" class="col-sm-2 control-label">截止日期</label>
                    <div class="col-sm-8">
                        <input type="time" class="form-control" name="time" id="date" >
                    </div>
                </div>
              

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-20">
                        <button type="submit" class="btn btn btn-info" id="regist">注册</button>
                    </div>
                </div>
            </form>
        </div>
  </body>
</html>
