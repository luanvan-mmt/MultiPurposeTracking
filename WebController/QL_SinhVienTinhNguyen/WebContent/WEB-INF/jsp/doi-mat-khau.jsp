<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đổi mật khẩu</title>

<link rel="stylesheet" href="../css/doi-mat-khau.css">
<script src="../js/doi-mat-khau.js" charset="utf-8"></script>

</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<table>
			<tr>
				<!-- MENU -->
				<td style="width: 245px;" valign="top">
					<jsp:include page="vertical-menu.jsp"></jsp:include>
				</td>

				<!-- CONTENT -->
				<td valign="top">
					<div class="changeContent">
						
						<div class="title">
							<h3>ĐỔI MẬT KHẨU</h3>
						</div>
						
						<div>
							<span>status: </span><span id="status">${message}</span>
						</div>
						
						<form:form action="ktMaSo.html" method="POST" id="formMaSo">
							<table id="tblMaso">
								<tr>
									<td>Vui lòng nhập vào Mã số của bạn: </td>
									<td><input type="text" id="maso" name="maso" class="inputChange"></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Đổi mật khẩu" class="btnChange"></td>
								</tr>
							</table>
						</form:form>
						
						<form:form action="ktMatKhau.html" method="POST" id="formMatKhau">
							<table id="tblMatKhau">
								<tr>
									<td>Mã số: </td>
									<td>
										<input type="text" id="masoOK" name="masoOK" class="inputChange" 
											value="${maso}" disabled="disabled">
									</td>
								</tr>
								<tr>
									<td>Nhập mật khẩu cũ của bạn: </td>
									<td><input type="text" id="oldPwd" name="oldPwd" class="inputChange"></td>
								</tr>
								<tr>
									<td>Nhập mật khẩu mới của bạn: </td>
									<td><input type="text" id="newPwd" name="newPwd" class="inputChange"></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Xác nhận" class="btnChange"></td>
								</tr>
							</table>
						</form:form>
						
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>