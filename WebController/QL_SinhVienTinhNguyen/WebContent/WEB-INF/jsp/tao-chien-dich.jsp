<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quan ly chien dich tinh nguyen</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<div class="container">
		<table style="width: 100%">
			<tr>
				<!-- MENU -->
				<td style="width: 245px;" valign="top">
					<jsp:include page="vertical-menu.jsp"></jsp:include>
				</td>

				<!-- CONTENT -->
				<td valign="top">
					<div class="content">
						<h3>QUẢN LÝ CHIẾN DỊCH TÌNH NGUYỆN</h3>
						<hr>
						<span class="infoTitle">Tạo chiến dịch tình nguyện</span>
						<hr>
						<form:form modelAttribute="ChienDich" method="POST"
							action="handle.html">
							<table>
								<tr>
									<td>Mã chiến dịch:</td>
									<td>
										<form:input path="maChienDich" disabled="disabled"/>
									</td>
								</tr>
								<tr>
									<td>Địa điểm thực hiện:</td>
									<td>
										<form:input path="diaDiem"/>
									</td>
								</tr>
								<tr>
									<td>Mục đích của chiến dịch:</td>
									<td>
										<form:textarea path="mucDich" />
									</td>
								</tr>
								<tr>
									<td>Thời gian diễn ra:</td>
									<td>
										<form:input path="thoiGianBD" />
									</td>
								</tr>
								<tr>
									<td>Thời gian kết thúc:</td>
									<td>
										<form:input path="thoiGianKT" />
									</td>
								</tr>
								<tr>
									<td>Số lượng Sinh viên:</td>
									<td>
										<form:input path="soLuong" />
									</td>
								</tr>
								<tr>
									<td>Yêu cầu:</td>
									<td>
										<form:textarea path="yeuCau" />
									</td>
								</tr>
								<tr>
									<td>Kế hoạch thực hiện:</td>
									<td>
										<form:textarea path="keHoach"/>
									</td>
								</tr>
								<tr>
									<td>Tệp đính kèm:</td>
									<td>
									</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<input type="submit" value="Tạo mới">
									</td>
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