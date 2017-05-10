<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<!-- CSS -->
<link href="<c:url value="/css/login-page.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<!-- MAIN PAGE -->
	<div class="container">
		<table>
			<tr>
				<!-- Khung dang nhap -->
				<td class="left" align="center" valign="top">
					<div style="height: 70px;">
						<img class="title-login" src='<c:url value="/img/title-login.png"/>' >
					</div>
					<div class="login">
						<form:form modelAttribute="User" method="POST" action="handle"
							class="form-horizontal">
							<div>
								<form:input path="userName" cssClass="userName"
									placeholder="Nhập mã số đăng nhập"/>
							</div>
							<div>
								<form:password path="password" cssClass="password"
									placeholder="Nhập mật khẩu"/>
							</div>
							<div class="error" id="message">${message}</div>
							<div align="center">
								<input type="submit" value="Đăng Nhập" class="btnLogin">
							</div>
						</form:form>
						<div class="link" align="left">
							<%String contextPath = request.getContextPath(); %>
							<a href="#">Quên mật khẩu?</a> <br>
							<a href="<%=contextPath%>/register/form.html">
								Đăng ký tài khoản mới</a>
						</div>
					</div>
					<img class="login-shadow" src='<c:url value="/img/bong-login.png"/>' >
					<div class="note" align="left">
						<b>* Ghi chú:</b>
						<p>1. Sinh viên cần phải đăng ký tài khoản trước khi đăng nhập vào đăng nhập vào hệ thống.</p>
						<p>2. Sinh viên sử dụng mã số sinh viên và mật khẩu được cung cấp trong email để đăng nhập.</p>
					</div>
				</td>
				
				<!-- Thong tin cac dot tinh nguyen -->
				<td align="center" valign="top">
					<div class="dotTN">
						<h3>Thông tin các đợt tình nguyện</h3>
						<table>
							<tr class="head">
								<td>Thời gian</td>
								<td>Địa điểm</td>
								<td>Đơn vị tổ chức</td>
							</tr>
							<tr class="clickable-row" id="idDotTN"> 
								<td>01/05/2017 - 10/05/2017</td>
								<td>Xã Vĩnh Lộc A, Huyện Hồng Dân, Bạc Liêu</td>
								<td>LCHSV Bạc Liêu</td>
							</tr>
						</table>
						<a href="#" class="seeAll">Xem tất cả >> </a>
					</div>
				</td>
			</tr>
		</table>
		<!-- <a href="map.html">Open Map</a> -->
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>