<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投票系统登录</title>
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
            <form class="form-horizontal" action="${pageContext.request.contextPath}/LoginServlet" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn btn-info" id="login">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <script type="text/javascript">
        	window.onload=function(){
        		var u=document.getElementById('user');
        		var psw=document.getElementById('password');
        		var lo=document.getElementById('login');
        		lo.onclick=function(){
        			if(u.value==""||psw.value==""){
        				alert("账号或密码不能为空");
                                        return false;
        			}
        		}
        	}
        </script>
  </body>
</html>
