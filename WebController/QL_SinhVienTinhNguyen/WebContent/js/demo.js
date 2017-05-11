var serverAddr;
var sipAccount;
var password;

window.onload = function() {
    // Can khoi tao 2 Button login va logout trong HTML
    setLoginButton('btn-login', 'btn-logout');
    // --> Neu giao dien khong can 2 nut nay thi co the set trong css: "display: hidden;"

    // Can khoi tao 4 Button trong HTML de xu ly qua trinh call
    // --> 1: Call : goi
    // --> 2: Hangup : cup may
    // --> 3: Answer : tra loi cuoc goi
    // --> 4: Reject : tu choi cuoc goi
    setCallButtons('btn-call', 'btn-hangup', 'btn-answer', 'btn-reject');

    prepare();

    setTimeout(loginSIP, 2000);
}

// Dang nhap sip account
function loginSIP() {
    // Thiet lap thong tin User
    serverAddr = "192.168.43.200";
    sipAccount = $('#txt-sipAccount').val() + '@' + serverAddr;
    password = $('#txt-password').val();

    setUserInfo('Chau Quoc Minh', sipAccount, password, serverAddr);

    // Thiet lap server:
    // --> Neu dung May ao Server thi dua vao dia chi server
    // --> Neu dung Remote Server thi set null
    setServerAddress(serverAddr);

    onClickLogin();
}

$(document).ready(function() {
    // Xu ly logout:
    $('#btn-logout').click(function() {
        onClickLogout();
    });

    // Goi thong qua SIP address:
    $('#btn-call').click(function() {
        makeVoiceCall($('#txt-sendTo').val());
    });

    // Lang nghe su kien cup may:
    $('#btn-hangup').click(function() {
        sipHangUp();
    });

    // Xu ly nut "Send message"
    $('#btn-send').click(function() {
        var msg = $('#txtMessage').val();

        var fullMessage = $('#txt-fullName').val() + '/' + $('#txtMessage').val();
        sendMessage($('#txt-sendTo').val(), fullMessage);

        displaySendMessage(msg);

        $('#txtMessage').val("");
    });

    // Lay row tu table
	var $row = $('#tblFriends').find('tr');
	// Xu ly su kien onlick tren row
	$row.on('click', function() {

		// Lay ra SIP username
        var sipUserName = $(this).find('td:last-child').find('input').val();
        // Lay ra FullName
		var fullName = $(this).find('td:first-child').html();

        // Set text cho Tile Chat box
        $('#titleName').text(fullName);
        clearMessageView();

        // Set Sip username cho input txt-sendTo
        $('#txt-sendTo').val('sip:' + sipUserName + '@' + serverAddr);
	});
});

function clearMessageView() {
    $('#messageView').html('<div></div>');
}

function displaySendMessage(message) {
    var displayName = $('#displayName').val();
    var message = '<div class="sent" align="right">' +
        '<div class="name" id="myName">' + $('#txt-fullName').val() + '</div>' +
        '<div class="msgSent">' + message + '</div>' +
        '</div>';
    $('#messageView').append(message);
}

// Xu ly tien trinh nhan tin nhan trong ham nay
// VD: set tin nhan len giao dien, luu vao csdl ...
// *** Ghi chu: dung su kien "e" de xu ly
function handleMessaging(e) {
    // Set lai nguoi nhận BEGIN ...

    // Lay ra SIP username
    // var sipUserName = $(this).find('td:last-child').find('input').val();
    // Lay ra FullName
    // var fullName = $(this).find('td:first-child').html();

    // Set text cho Tile Chat box
    // $('#titleName').text(fullName);

    // Set Sip username cho input txt-sendTo
    // $('#txt-sendTo').val('sip:' + sipUserName + '@' + serverAddr);

    // ... END Set lai nguoi nhận

    // Hien thi tin nhan
    setTimeout(displayReceivedMessage(e), 1000);
}

function displayReceivedMessage(e) {
    var fullMessage = e.getContentString();

    var fields = fullMessage.split('/');

    var displayName = fields[0];
    var msg = fields[1]

    var message = '<div class="received">' +
        '<div class="name">' + displayName + '</div>' +
        '<div class="msgReceived">' + msg + '</div>' +
        '</div>';
    $('#messageView').append(message);
}
