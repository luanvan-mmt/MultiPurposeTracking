<%@page import="com.dev.mongodb.controller.NguoiDungColl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dev.model.NguoiDung"%>
<%@page import="com.dev.model.CanBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Communication</title>
	<script src="../js/jquery-1.7.2.min.js" charset="utf-8"></script>
    <script src="../js/api/SIPml-api.js" charset="utf-8"></script>
    <script src="../js/api/chat-api.js" charset="utf-8"></script>
    <script src="../js/demo.js" charset="utf-8"></script>
    
    <link rel="stylesheet" href="../css/chat.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<% 
		NguoiDung nguoiDung = (NguoiDung) session.getAttribute("User");
		String displayName = nguoiDung.getFullName();
	%>
	
	<div class="container">
		<table style="width: 100%">
			<tr>
				<!-- MENU -->
				<td style="width: 230px;" valign="top">
					<jsp:include page="vertical-menu.jsp"></jsp:include>
				</td>

				<!-- MESSAGE BOX -->
				<td valign="top">
					<div id="msgContainer">
						<table class="tblMessage">
							<tr class="msgHeader">
								<td>
									<table width="100%">
										<tr>
											<td style="width: 50px;" align="center">
												<img class="user-icon" src="../img/user-icon.png">
											</td>
											<td>
												<h3 id="titleName">Name</h3>
											</td>
											<td>
												<div align="right">
						                        	<input id="btn-call" type="button" value="Call">
											        <input id="btn-hangup" type="button" value="Hangup">
											        <input id="btn-answer" type="button" value="Answer">
											        <input id="btn-reject" type="button" value="Reject">
						                        </div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="msgBody">
								<td>
									<div id="messageView"></div>
								</td>
							</tr>
							<tr class="msgInput">
								<td>
									<table class="tblInputMsg">
		                                <tr>
		                                    <td><textarea id="txtMessage" rows="2" cols="53"></textarea></td>
		                                    <td><input id="btn-send" type="button" value="Gửi"></td>
		                                </tr>
		                            </table>
								</td>
							</tr>
							<tr>
								<td>
									<div class="status">Status: <i><span id="status"></span></i></div>
								</td>
							</tr>
						</table>
					</div>				
				</td>
				
				<%
					NguoiDungColl coll = new NguoiDungColl();
					List<NguoiDung> dsNguoiDung = new ArrayList<NguoiDung>();
					dsNguoiDung = coll.getAll();
				%>
				
				<!-- LIST FRIEND -->
				<td  style="width: 230px;" valign="top">
					<div class="friendHeader">
						<h4>DANH SÁCH NGƯỜI DÙNG</h4>
					</div>
					<div class="friendList">
						<table id="tblFriends" width="100%" class="tblFriends">
							<%for (NguoiDung user : dsNguoiDung) { %>
								
								<tr>
									<td><%=user.getFullName()%></td>
									
									<%if(user.isSipStatus()) { %>
										<td style="color: green">
											Online
											<input type="text" value="<%=user.getUserNameSip()%>">
										</td>
									<%} else {%>
										<td style="color: #ccc">
											Offline
											<input type="text" value="<%=user.getUserNameSip()%>">
										</td>
									<%} %>
									
								</tr>
							
							<%} %>
						</table>
					</div>
					
				</td>
			</tr>
		</table>
	</div>
	
	<input id="txt-sendTo" type="text" value="">
    
    <input id="txt-sipAccount" type="text" value="<%=nguoiDung.getUserNameSip()%>">
    <input id="txt-password" type="text" value="<%=nguoiDung.getPasswordSip()%>">
    <input id="txt-fullName" type="text" value="<%=nguoiDung.getFullName()%>">
    
    <input id="btn-login" type="button" value="Login">
    <input id="btn-logout" type="button" value="Logout">
    
    <!-- Audio here -->
    <audio id="audio_remote" autoplay="autoplay" />
    <audio id="ringtone" loop src="../sounds/ringtone.wav"> </audio>
    <audio id="ringbacktone" loop src="../sounds/ringbacktone.wav"> </audio>
    <audio id="dtmfTone" src="../sounds/dtmf.wav"> </audio>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>