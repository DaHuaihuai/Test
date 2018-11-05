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
    
    <title>My JSP 'list.jsp' starting page</title>
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
	    <table class="table table-striped">
		    <thead>
			    <tr>
			    	<th>主题</th>
			    	<th>发起者</th>
			    	<th>截止日期</th>
			    	<th></th>
			    </tr>
		    </thead>
		    <tbody>
		    <!-- 该循环将map从list中取出放入变量queryMap中 -->
		    <c:forEach items="${requestScope.queryList}" var="vote">
		    	<tr>			  
		    	<!-- 从map中获取属性值 --> 		
			    	<td>${vote.vname}</td>
			    	<td>${vote.username}</td>
			    	<td>${vote.deadline}</td>
			    	<td><a href="JoinServlet?vid=${vote.vid }&deadline=${vote.deadline}">参与投票</a>
			    		<a>查看详情</a></td>
		    	</tr>
		    </c:forEach>
		    
		    </tbody>
	    </table>
	    
    </div>
  </body>
</html>
