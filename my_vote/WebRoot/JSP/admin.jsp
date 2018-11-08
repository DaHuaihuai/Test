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
    
    <title>My JSP 'admin.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    
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
			    	<th>投票类型</th>
			    	<th>总投票数</th>
			    	<th>举报情况</th>
			    	<th></th>
			    </tr>
		    </thead>
		    <tbody>
		    <!-- 该循环将map从list中取出放入变量queryMap中 -->
		    <c:forEach items="${requestScope.pageList.beanList}" var="vote">
		    	<tr>			  
		    	<!-- 从map中获取属性值 --> 		
			    	<td>${vote.vname}</td>
			    	<td>${vote.username}</td>
			    	<td>${vote.deadline}</td>
			    	<c:choose>
				    	<c:when test="${vote.vtype==0}">
				    		<td>单选</td>
				    	</c:when>
				    	<c:otherwise>
				    		<td>多选</td>
				    	</c:otherwise>
			    	</c:choose>
			    	<td>${vote.onumber}</td>
			    	<c:choose>
				    	<c:when test="${vote.vreport==0}">
				    		<td>未被举报</td>
				    	</c:when>
				    	<c:otherwise>
				    		<td>已被举报</td>
				    	</c:otherwise>
			    	</c:choose>
			    	<td>
			    		<a href="JSP/info.jsp?vname=${vote.vname}&vid=${vote.vid}">查看详情</a>
			    		<c:if test="${vote.vreport==1}">
				    		<a href="RemoveServlet?vid=${vote.vid}">撤销举报</a>
				    		<a href="DeleteServlet?vid=${vote.vid}">删除投票</a>
			    		</c:if></td>
		    	</tr>
		    </c:forEach>
		    
		    </tbody>
	    </table>
	    <ul class="pagination">
			<li><a href="AdminServlet?pc=1">&laquo;</a></li>
			<c:choose>
				<%-- 总页数小于列表数（10），展示所有页 --%>
				<c:when test="${pageList.tp <= 10}">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="${pageList.tp}"/>
				</c:when>
				<%--总页数大于列表数，通过当前页码计算应显示页 --%> 
				<c:otherwise>
					<c:set var="begin" value="${pageList.pc-5 }" />
					<c:set var="end" value="${pageList.pc+4 }" />
					
					<c:if test="${begin < 1}">
						<c:set var="begin" value="1" />
						<c:set var="end" value="10" />
					</c:if>
					
					<c:if test="${end > pageList.tp}">
						<c:set var="begin" value="${pageList.tp-9}" />
						<c:set var="end" value="${pageList.tp }" />
					</c:if>
				</c:otherwise>
			</c:choose>
			
			<!-- 循环显示页数 -->
			<c:forEach var="i" begin="${begin }" end="${end }">
				<li><a href="AdminServlet?pc=${i }">${i}</a></li>
			</c:forEach>
			<li><a href="AdminServlet?pc=${pageList.tp }">&raquo;</a></li>
		</ul>
    </div>
  </body>
</html>
