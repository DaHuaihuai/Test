<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addoption.jsp' starting page</title>
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
      <form class="form-horizontal" action="NewoptionServlet" method="post">
      <input type="hidden" name="vid" value="${vid }">
		  <c:forEach begin="1" end="${options}" varStatus="id">
		   <div class="form-group">
			  <label for="vote_option" class="col-sm-2 control-label">选项${id.count}</label>
		             <div class="col-sm-8">
		                 <input type="text" class="form-control" name="option${id.count}" id="option" >
		             </div>
           </div>	
		  </c:forEach>
		  <div class="form-group">
                    <div class="col-sm-offset-10 col-sm-10">
                        <button type="submit" class="btn btn btn-info" >完成</button>
                    </div>
                </div>
	  </form>
  </div>
  </body>
</html>
