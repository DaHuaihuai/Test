<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

        <title>投票系统注册</title>
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
            <form class="form-horizontal" action="${pageContext.request.contextPath}/RegistServlet" method="post">
            
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
                    <label for="phone" class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="手机号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="email" id="email" placeholder="邮箱">
                    </div>
                </div>
                <div class="form-group">
                    <label for="verifyCode" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="verifyCode" id="verifyCode">
                        <img id="img" src="${pageContext.request.contextPath}/VerifyServlet" />
    			        <a href="javascript:change()">看不清，换一张</a>${errors.verifyCode }
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-20">
                        <button type="submit" class="btn btn btn-info" id="regist">注册</button>
                    </div>
                </div>
            </form>
        </div>
         <script type="text/javascript">
        	window.onload=function(){
        		var uname=document.getElementById('username');
        		var psw=document.getElementById('password');
        		var up=document.getElementById('phone');
        		var ue=document.getElementById('email');
        		var re=document.getElementById('regist');
        		re.onclick=function(){
        			if(u.value==""||uname.value==""||psw.value==""||up.value==""||ue.value==""){
        				alert("请完善信息！");
                        return false;
        			}
        		}
        	}
        	
        	function change(){
        	  	var imgEle=document.getElementById("img");
        	  	imgEle.src="${pageContext.request.contextPath}/VerifyServlet?time="+new Date().getTime();
        	  	}
        </script>
  </body>
</html>
