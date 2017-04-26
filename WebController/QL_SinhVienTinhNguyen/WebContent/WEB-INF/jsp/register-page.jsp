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

</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<%String pageName = "register-page"; %>

	<div class="container">
		<table>
			<tr>
				<!-- MENU -->
				<td style="width: 245px;" valign="top">
					<jsp:include page="vertical-menu.jsp"></jsp:include>
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
									<select id="role">
										<option value="can-bo">Cán Bộ</option>
										<option value="sinh-vien">Sinh Viên</option>
									</select>
								</td>
							</tr>
						</table>

						<!-- FORM DANG KY SINH VIEN -->
						<form:form modelAttribute="Student" method="post" action="handle-student.html" id="formSinhVien">
							<table class="tblRegister">
								<tr>
									<td>Mã số sinh viên:</td>
									<td><form:input path="mssv" placeholder="Nhập mã số sinh viên"/></td>
								</tr>
								<tr>
									<td>Họ tên sinh viên:</td>
									<td><form:input path="hoTen" placeholder="Nhập họ tên của bạn"/></td>
								</tr>
								<tr>
									<td>Giới tính:</td>
									<td>
										<form:select path="gioiTinh">
											<form:option value="nam">Nam</form:option>
											<form:option value="nu">Nữ</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td>Số điện thoại:</td>
									<td><form:input path="sdt" placeholder="Nhập số điện thoại của bạn"/></td>
								</tr>
								<tr>
									<td>Địa chỉ:</td>
									<td><form:input path="diaChi" placeholder="Nhập địa chỉ của bạn"/></td>
								</tr>
								<tr>
									<td>CMND:</td>
									<td><form:input path="cmnd" placeholder="Nhập số cmnd của bạn"/></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><form:input path="email" placeholder="VD: minhb1304568@student.ctu.edu.vn"/></td>
								</tr>
								<tr>
									<td>Mã lớp:</td>
									<td><form:input path="maLop" placeholder="VD: DI13Y9A2"/></td>
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
						<form:form modelAttribute="Staff" method="post" action="handle-staff.html" id="formCanBo">
							<table class="tblRegister">
								<tr>
									<td>Mã số cán bộ:</td>
									<td><form:input path="mscb" placeholder="Nhập mã số cán bộ"/></td>
								</tr>
								<tr>
									<td>Họ tên cán bộ:</td>
									<td><form:input path="hoTen" placeholder="Nhập họ tên của bạn"/></td>
								</tr>
								<tr>
									<td>Chức vụ:</td>
									<td>
										<form:select path="chucVu">
											<form:option value="nhan-vien">Nhân viên văn phòng</form:option>
											<form:option value="giang-vien">Giảng viên</form:option>
											<form:option value="other">Khác</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td>Giới tính:</td>
									<td>
										<form:select path="gioiTinh">
											<form:option value="male">Nam</form:option>
											<form:option value="female">Nữ</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td>Số điện thoại:</td>
									<td><form:input path="sdt" placeholder="Nhập số điện thoại của bạn"/></td>
								</tr>
								<tr>
									<td>Địa chỉ:</td>
									<td><form:input path="diaChi" placeholder="Nhập địa chỉ của bạn"/></td>
								</tr>
								<tr>
									<td>CMND:</td>
									<td><form:input path="cmnd" placeholder="Nhập số cmnd của bạn"/></td>
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
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#formSinhVien').hide(); 	// An form Sinh vien 
			$('#formCanBo').show();		// Hien form Can bo
			
			// Xu ly su kien Select
			$('#role').change(function() {
				if($('#role :selected').val() == "sinh-vien") { 
					$('#formSinhVien').show();
					$('#formCanBo').hide();
				} else {
					$('#formSinhVien').hide();
					$('#formCanBo').show();
				}
			});
		});
	</script>

	<jsp:include page="footer.jsp"/>
</body>
</html>
