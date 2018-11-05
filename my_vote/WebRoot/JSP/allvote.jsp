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
    
    <title>My JSP 'allvote.jsp' starting page</title>
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
		    <c:forEach items="${requestScope.queryList.beanList}" var="vote">
		    	<tr>			  
		    	<!-- 从map中获取属性值 --> 		
			    	<td>${vote.vname}</td>
			    	<td>${vote.username}</td>
			    	<td>${vote.deadline}</td>
			    	<td><a href="JoinServlet?vid=${vote.vid}&deadline=${vote.deadline}">参与投票</a> 
			    		<a>查看详情</a></td>
		    	</tr>
		    </c:forEach>
		    
		    </tbody>
	    </table>
	    <ul class="pagination">
			<li><a href="ListServlet?pc=1">&laquo;</a></li>
			<c:choose>
				<%-- 总页数小于列表数（10），展示所有页 --%>
				<c:when test="${queryList.tp <= 10}">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="${queryList.tp}"/>
				</c:when>
				<%--总页数大于列表数，通过当前页码计算应显示页 --%> 
				<c:otherwise>
					<c:set var="begin" value="${queryList.pc-5 }" />
					<c:set var="end" value="${queryList.pc+4 }" />
					
					<c:if test="${begin < 1}">
						<c:set var="begin" value="1" />
						<c:set var="end" value="10" />
					</c:if>
					
					<c:if test="${end > queryList.tp}">
						<c:set var="begin" value="${queryList.tp-9}" />
						<c:set var="end" value="${queryList.tp }" />
					</c:if>
				</c:otherwise>
			</c:choose>
			
			<!-- 循环显示页数 -->
			<c:forEach var="i" begin="${begin }" end="${end }">
				<li><a href="ListServlet?pc=${i }">${i}</a></li>
			</c:forEach>
			<li><a href="ListServlet?pc=${queryList.tp }">&raquo;</a></li>
		</ul>
    </div>
  </body>
</html>
