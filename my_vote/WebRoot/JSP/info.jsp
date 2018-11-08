<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String vnameString = request.getParameter("vname");
request.setAttribute("vname", vnameString);
String vidString = request.getParameter("vid");
request.setAttribute("vid", vidString);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info.jsp' starting page</title>
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
	      <form class="form-horizontal" action="ReportServlet" method="post">
	      <input type="hidden" name="vid" value="${vid }" />
	      	<div class="col-sm-offset-4">
		    	<h3>${vname}</h3>
	    	</div>
	    	<div class="col-sm-offset-3">
		    	<img src="${pageContext.request.contextPath}/ChartServlet?vid=${vid}" />
		    </div>
		    <div class="col-sm-offset-8">
		    	<input type="button" id="back" onclick="javascript:history.back(-1);" value="返回"/>
		    	<input type="submit" id="report" value="举报投票"/>
	    	</div>
	    </form>
	  </div>
	  <script type="text/javascript">
        	window.onload=function(){
        		var re=document.getElementById('report');
        		re.onclick=function(){
        			alert("举报成功！");
                    return true;
        		}
        	}
        </script>
	</body>
</html>
