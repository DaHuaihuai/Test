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
    
    <title>My JSP 'myvote.jsp' starting page</title>
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
			    	<th>投票类型</th>
			    	<th>举报信息</th>
			    	<th>截止日期</th>
			    	<th> </th>
			    </tr>
		    </thead>
		    <tbody>
		    <c:forEach items="${voteList}" var="vote">
		    	<tr>			  	
			    	<td>${vote.vname}</td>
			    	<c:choose>
			    		<c:when test="${vote.vtype==0}">
			    			<td>单选</td>
			    		</c:when>
			    		<c:otherwise>
			    			<td>多选</td>
			    		</c:otherwise>
			    	</c:choose>
			    	<c:choose>
			    		<c:when test="${vote.vreport==0}">
			    			<td>未被举报</td>
			    		</c:when>
			    		<c:otherwise>
			    			<td>已被举报</td>
			    		</c:otherwise>
			    	</c:choose>
			    	<td>${vote.deadline}</td>
			    	<td><a href="ChartServlet?vid=${vote.vid}">查看选项详情</a></td>
		    	</tr>
		    </c:forEach>
		    
		    </tbody>
	    </table>
    </div>
  </body>
</html>
