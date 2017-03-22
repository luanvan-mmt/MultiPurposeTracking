<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/login.css">
<title>Login</title>
</head>
<body>
	<!-- HEADER -->
	<div id="header">
	
	</div>
	
	<!-- BODY -->
	<div id="mainContain">
		<form:form modelAttribute="User" method="POST" action="handle.html">
			<form:label path="userName">Mã số:</form:label>
			<form:input path="userName" />
			<br>
			<form:label path="password">Mật khẩu:</form:label>
			<form:password path="password" />
			<br>
			<div id="error">${message}</div>
			<br>
			<input type="submit" value="Đăng nhập">
		</form:form>
	</div>
	
	<!-- FOOTER -->
	<div id="footer">
	
	</div>
	
		
</body>
</html>