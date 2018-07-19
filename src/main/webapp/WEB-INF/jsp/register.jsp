<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
  <h1>注册</h1>
	<form:form action="" method="POST" commandName="user">
		<sec:csrfInput/>
		<div>
			<form:label path="username">用户名：</form:label>
			<form:input path="username" />
			<form:errors path="username" ></form:errors>
		</div>
		
		<div>
			<form:label path="password">密码：</form:label>
			<form:input path="password" type="password" />
			<form:errors path="password" ></form:errors>
		</div>
		
		<div>
			<form:label path="description">描述：</form:label>
			<form:input path="description" />
			<form:errors path="description" ></form:errors>
		</div>
		
		<div>
			<button type="submit">提交</button>
		</div>
	
	</form:form>
</body>
</html>
