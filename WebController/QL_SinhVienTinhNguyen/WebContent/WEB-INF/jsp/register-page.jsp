<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="../css/register.css">
<title>Đăng ký</title>
<script type="text/javascript">
function setRegisterForm() {
	var role = document.getElementById("role");
	var strRole = role.options[role.selectedIndex].value;
	
	if(strRole == "sinhVien") {
		document.getElementById("formSinhVien").style.display = "block";
		document.getElementById("formCanBo").style.display = "none";
	} else {
		document.getElementById("formSinhVien").style.display = "none";
		document.getElementById("formCanBo").style.display = "block";
	}
}
</script>
</head>
<body onload="setRegisterForm()">
	<jsp:include page="header.jsp"/>
	
	<div class="container">
		<table>
			<tr>
				<!-- MENU -->
				<td style="width: 245px;" valign="top">
					<div class="verticalMenu" align="center">
						MENU <br>
						<a href="login.html">Quay lai</a>
					</div>
				</td>
				
				<!-- CONTENT -->
				<td valign="top">
					<div class="registerContent">
						<div>
							<img class="title-login" src="../img/register-title.png" >
						</div>
						
						<table class="role">
							<tr>
								<td>Bạn là : </td>
								<td>
									<select id="role" onchange="setRegisterForm()">
										<option value="sinhVien">Sinh Viên</option>
										<option value="canBo">Cán Bộ</option>
									</select>
								</td>
							</tr>
						</table>
						
						<!-- FORM DANG KY SINH VIEN -->
						<form:form modelAttribute="Student" method="post" action="handleStudent.html" id="formSinhVien">
							<table class="tblRegister">
								<tr>
									<td>Mã số sinh viên:</td>
									<td><form:input path="studentId" placeholder="Nhập mã số sinh viên"/></td>
								</tr>
								<tr>
									<td>Họ tên sinh viên:</td>
									<td><form:input path="fullName" placeholder="Nhập họ tên của bạn"/></td>
								</tr>
								<tr>
									<td>Giới tính:</td>
									<td>
										<form:select path="sex">
											<form:option value="male">Nam</form:option>
											<form:option value="female">Nữ</form:option>
											<form:option value="other">Khác</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td>Số điện thoại:</td>
									<td><form:input path="phone" placeholder="Nhập số điện thoại của bạn"/></td>
								</tr>
								<tr>
									<td>Địa chỉ:</td>
									<td><form:input path="address" placeholder="Nhập địa chỉ của bạn"/></td>
								</tr>
								<tr>
									<td>CMND:</td>
									<td><form:input path="idNumber" placeholder="Nhập số cmnd của bạn"/></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><form:input path="email" placeholder="VD: minhb1304568@student.ctu.edu.vn"/></td>
								</tr>
								<tr>
									<td>Mã lớp:</td>
									<td><form:input path="classCode" placeholder="VD: DI13Y9A2"/></td>
								</tr>
								<tr>
									<td></td>
									<td>
										<input id="btnSubmit" type="submit" value="Đăng Ký">
									</td>
								</tr>
							</table>
						</form:form>
						
						<!-- FORM DANG KY CAN BO -->
						<form:form modelAttribute="Staff" method="post" action="handle.html" id="formCanBo">
							<table class="tblRegister">
								<tr>
									<td>Mã số cán bộ:</td>
									<td><form:input path="staffId" placeholder="Nhập mã số cán bộ"/></td>
								</tr>
								<tr>
									<td>Họ tên cán bộ:</td>
									<td><form:input path="fullName" placeholder="Nhập họ tên của bạn"/></td>
								</tr>
								<tr>
									<td>Chức vụ:</td>
									<td>
										<form:select path="position">
											<form:option value="male">Giảng viên</form:option>
											<form:option value="female">Nhân viên văn phòng</form:option>
											<form:option value="other">Khác</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td>Giới tính:</td>
									<td>
										<form:select path="sex">
											<form:option value="male">Nam</form:option>
											<form:option value="female">Nữ</form:option>
											<form:option value="other">Khác</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td>Số điện thoại:</td>
									<td><form:input path="phone" placeholder="Nhập số điện thoại của bạn"/></td>
								</tr>
								<tr>
									<td>Địa chỉ:</td>
									<td><form:input path="address" placeholder="Nhập địa chỉ của bạn"/></td>
								</tr>
								<tr>
									<td>CMND:</td>
									<td><form:input path="idNumber" placeholder="Nhập số cmnd của bạn"/></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><form:input path="email" placeholder="VD: minhb1304568@student.ctu.edu.vn"/></td>
								</tr>
								<tr>
									<td></td>
									<td>
										<input id="btnSubmit" type="submit" value="Đăng Ký">
									</td>
								</tr>
							</table>
						</form:form>
					</div>
					<div style="margin-left: 10px;">
						<img class="title-login" src="../img/register-shadow.png" >
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>