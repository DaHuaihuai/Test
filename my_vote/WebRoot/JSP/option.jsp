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
    
    <title>My JSP 'option.jsp' starting page</title>
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
	<p style="color: red ; font-weight: 600">${msg }</p>
    <form class="form-horizontal" action="ConfirmVoteServlet" method="get">
    	<input type="hidden" id="dl" name="deadline" value="${deadline}"/>
    	<input type="hidden" name="vtype" value="${vtype}"/> 
    	<input type="hidden" name="vid" value="${vid}"/> 
    	<input type="hidden" name="uid" value="${sessionUser.uid}"/> 

	    <c:choose>
	    <%-- 判断投票类型，0为单选，1为多选 --%>
	    	<c:when test="${vtype==0 }">
	    		<c:forEach items="${optionList}" var="option">
		   		    <div class="radio">
		    			<label>
		       				 <input type="radio" name="option" id="optionsRadios1" value="${option.oid}" />${option.oname}
		    			</label>
					</div>
				</c:forEach>
	    	</c:when>
	    	<c:otherwise>
	    		<c:forEach items="${optionList}" var="option">
			   	    <div class="checkbox">
			   			<label><input type="checkbox" name="option" value="${option.oid}">${option.oname}</label>
					</div>
				</c:forEach>
	    	</c:otherwise>
	    </c:choose>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-20">
                <button type="submit" class="btn btn btn-info" id="confirm">确认投票</button>
            </div>
        </div>
    </form>
   </div>
     <!-- 验证该投票是否超过截止日期 -->
	  <script type="text/javascript">
	  window.onload=function(){
  		var deadline=document.getElementById('dl');
  		var nowTime=new Date();
  		var deadTime = new Date(deadline.value);

  		var con=document.getElementById('confirm');
  		con.onclick=function(){
  			if(nowTime.getTime()>deadTime.getTime()){
  				alert("超过投票截止日期！");
                  return false;
  			}
  		}
  	}
	  </script>
  </body>
</html>
