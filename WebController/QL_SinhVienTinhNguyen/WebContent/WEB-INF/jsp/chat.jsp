<%@page import="model.CanBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Communication</title>
	<script src="../js/jquery-1.7.2.min.js" charset="utf-8"></script>
    <script src="../js/api/SIPml-api.js" charset="utf-8"></script>
    <script src="../js/api/chat-api.js" charset="utf-8"></script>
    <script src="../js/chat.js" charset="utf-8"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<% 
		CanBo canbo = (CanBo) session.getAttribute("CanBo"); 
		String displayName = canbo.getHoTen();
	%>
	
	<div class="container">
		<table style="width: 100%">
			<tr>
				<!-- MENU -->
				<td style="width: 245px;" valign="top">
					<jsp:include page="vertical-menu.jsp"></jsp:include>
				</td>

				<!-- MESSAGE BOX -->
				<td valign="top">
					<div class="content">
						<div>
							<h3><%= displayName %></h3>
							<div align="right">
								
							</div>
						</div>
						
						<hr>
						<div>
							<span class="infoTitle">Thông tin các chiến dịch đã tạo</span>
							<a href="create/form.html" class="btnTaoMoi">+ TẠO CHIẾN DỊCH MỚI</a>
						</div>
						<hr>
						
					</div>
				</td>
				
				<!-- LIST FRIEND -->
				<td>
					<h4>DANH SÁCH BẠN BÈ</h4>
				</td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="footer.jsp"/>

	
	<input type="text" id="displayName" value="<%=canbo.getHoTen()%>">
	
	<label>Châu Quốc Minh</label>

    <input id="txt-sipAccount" type="text" value="cqm">
    <input id="txt-password" type="text" value="cqmcqm">
    <input id="txt-serverAddr" type="text" value="192.168.201.200">
    <input id="btn-login" type="button" value="Login">
    <input id="btn-logout" type="button" value="Logout">

    <input id="btn-call" type="button" value="Call">
    <input id="btn-hangup" type="button" value="Hangup">
    <input id="btn-answer" type="button" value="Answer">
    <input id="btn-reject" type="button" value="Reject">

    <p>Status: <i><span id="status"></span></i></p>

    <h3>MESSENGER</h3>
    <div id="msgContainer">
        <div id="messageView">

        </div>
        <input type="text" id="txt-sendTo" value="sip:cqm@192.168.201.200"><br><br>
        <textarea id="txtMessage" rows="4" cols="30"></textarea><br>
        <input id="btn-send" type="button" value="Send Message">
    </div>

    <!-- Audio here -->
    <audio id="audio_remote" autoplay="autoplay" />
    <audio id="ringtone" loop src="api/sounds/ringtone.wav"> </audio>
    <audio id="ringbacktone" loop src="api/sounds/ringbacktone.wav"> </audio>
    <audio id="dtmfTone" src="api/sounds/dtmf.wav"> </audio>
</body>
</html>