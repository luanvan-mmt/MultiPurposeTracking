<%@page import="com.dev.model.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.menu-main {
	width: 100%;
	border: 1px solid #268AFF;
	border-radius: 5px 5px 0 0;
}
.menu-header {
	background-image: linear-gradient(-225deg, #22E1FF 0%, #1D8FE1 48%, #625EB1 100%);
}
.menu-header h3 {
	padding: 8px 0;
	margin: 0;
	text-align: center;
	color: white;
}
.menu-item table {
	width: 100%;
	border-collapse: collapse;
	border-radius: 5px 5px 0 0;
}
.menu-item table tr {
	border: 1px solid #268AFF;
	height: 35px;
}
.menu-item table tr td {
	color: #268AFF;
	font-size: 14px;
}
.menu-item table tr td:FIRST-CHILD {
	width: 90%;
	text-indent: 40px;
}
.menu-item table tr td:FIRST-CHILD a {
	text-decoration: none;
	color: #268AFF;
}
.menu-item table tr:HOVER {
	background-color: #268AFF;
	border-color: white;
	height: 40px;
	cursor: pointer;
}
.menu-item table tr:HOVER td, 
.menu-item table tr:HOVER td:FIRST-CHILD a {
	color: white;
}
</style>
</head>
<body>
	<%
		String contextPath = request.getContextPath();
		NguoiDung user = (NguoiDung) session.getAttribute("User");
		
		int role = 0;
		try {
			role = user.getRole();
		} catch (NullPointerException e) {
			role = -1;
		}
		
	%>
	<div class="menu-main">
		<div class="menu-header">
			<h3>MENU</h3>
		</div>
		<div class="menu-item">
			<table id="tbl-menu">
					<tr>
						<td>
							<a href="<%=contextPath%>/home-page">Trang Chủ</a>
						</td>
						<td>></td>
					</tr>
				<%if(role == 2) { %>
					<tr>
						<td><a href="<%=contextPath%>/chien-dich-tinh-nguyen/quan-ly">Quản lý chiến dịch</a></td>
						<td>></td>
					</tr>
				<%} %>
				<%if(role == -1 || role == 3) { %>
					<tr>
						<td><a href="#">Thông tin các chiến dịch</a></td>
						<td>></td>
					</tr>
				<%} %>
					<tr>
						<td><a href="#">Thông báo</a></td>
						<td>></td>
					</tr>
				<%if(role == 3 || role == 2) { %>
					<tr>
						<td><a href="<%=contextPath%>/chat/init.html">Chat</a></td>
						<td>></td>
					</tr>
					<tr>
						<td><a href="<%=contextPath%>/logout">Đăng xuất</a></td>
						<td>></td>
					</tr>
				<%} %>
			</table>
		</div>
	</div>
		
	<script type="text/javascript">
		$(document).ready(function() {
			// Lay row tu table
			var $row = $('#tbl-menu').find('tr');
			
			// Xu ly su kien onlick tren row
			$row.on('click', function() {
				
				// Lay ra the a
				var $a = $(this).find('td:first-child').find('a');
				
				// Chuyen den link
				window.location.href = $a.attr('href');
			});
		});
		
	</script>
</body>
</html>