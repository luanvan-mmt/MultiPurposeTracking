<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
						<div>
							<span class="infoTitle">Thông tin các chiến dịch đã tạo</span>
							<a href="create/form.html" class="btnTaoMoi">+ TẠO CHIẾN DỊCH MỚI</a>
						</div>
						<hr>
						
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>