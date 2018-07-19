<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ attribute name="title" required="true" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title} </title>

<style type="text/css">
/* .menu {
    display: inline-block;
} */

</style>

</head>
<body>
	<div class="header">
		<ul>
			<sec:authentication property="principal" var="principal" />
			<c:if test="${principal != 'anonymousUser' }">
				<li>${principal.username} 
				      <form action="${contextPath}/logout" method="post" style="display: inline;">
        				<sec:csrfInput />
        				<button type="submit">退出</button>
      				 </form>
				</li>
			</c:if>
			
			<c:if test="${principal == 'anonymousUser' }">
				<li>
					<a href="${contextPath}/register">注册</a>
					<a href="${contextPath}/login">登录</a>
				</li>
			</c:if>
		</ul>
	</div>
	
	<div class="context">
		<jsp:doBody />
	</div>
	
	<div class="footer">
		TODO copyright 2018
	</div> 

</body>
</html>
</html>