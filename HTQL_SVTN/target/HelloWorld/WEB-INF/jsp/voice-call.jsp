<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Call over sip demo</title>

    <!-- SIPML5 API:
    DEBUG VERSION: 'SIPml-api.js'
    RELEASE VERSION: 'release/SIPml-api.js'
    -->
    <script src="../js/api/SIPml-api.js?svn=230" type="text/javascript"> </script>
    <script src="../js/voice-call.js" charset="utf-8"></script>

    <!-- Styles -->
    <link rel="stylesheet" href="demo.css">
</head>
<body style="cursor:wait">
    <div class="registration">
        <label style="width: 100%;" id="txtRegStatus"></label>
        <h2>Registration</h2>
        <table>
            <tr>
                <td><label>Display name:</label></td>
                <td><input type="text" id="txtDisplayName" value="" placeholder="e.g: Chau Quoc Minh"></td>
            </tr>
            <tr>
                <td><label>Username:</label></td>
                <td><input type="text" id="txtPrivateIdentity" value="" placeholder="e.g: cqm"></td>
            </tr>
            <tr>
                <td><label>SIP address:</label></td>
                <td><input type="text" id="txtPublicIdentity" value="" placeholder="e.g: sip:cqm@sipdomain.com"></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><input type="password" id="txtPassword" value="" placeholder="e.g: sip:cqm@sipdomain.com"></td>
            </tr>
            <tr>
                <td><label>Domain:</label></td>
                <td><input type="text" id="txtRealm" value="" placeholder="e.g:sipdomain.com"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="button" id="btnRegister" value="Log In" disabled onclick='sipRegister();' />
                    &nbsp;
                    <input type="button" id="btnUnRegister" value="Log Out" disabled onclick='sipUnRegister();' />
                </td>
            </tr>
        </table>
    </div>
    <div id="divCallCtrl">
        <label style="width: 100%;" id="txtCallStatus"></label>
        <h2>Call Control</h2>
        <input type="text" id="txtPhoneNumber" value="" placeholder="Enter phone number or SIP address to call" />
        <div id="divBtnCallGroup" class="btn-group">
            <button id="btnCall" disabled data-toggle="dropdown">Call</button>
        </div>&nbsp;&nbsp;
        <div class="btn-group">
            <input type="button" id="btnHangUp" value="HangUp" onclick='sipHangUp();' disabled />
        </div>
    </div>

    <!-- Call button options -->
    <ul id="ulCallOptions" class="dropdown-menu" style="visibility:hidden">
        <li><a href="#" onclick='sipCall("call-audio");'>Audio</a></li>
        <li hidden="hidden"><a href="#" onclick='sipCall("call-audiovideo");'>Video</a></li>
        <li hidden="hidden" id='liScreenShare' ><a href="#" onclick='sipShareScreen();'>Screen Share</a></li>
        <li hidden="hidden" class="divider"></li>
        <li hidden="hidden"><a href="#" onclick='uiDisableCallOptions();'><b>Disable these options</b></a></li>
    </ul>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="./assets/js/jquery.js"></script>
    
    <!-- Audios -->
    <audio id="audio_remote" autoplay="autoplay" />
    <audio id="ringtone" loop src="sounds/ringtone.wav" />
    <audio id="ringbacktone" loop src="sounds/ringbacktone.wav" />
    <audio id="dtmfTone" src="sounds/dtmf.wav" />

</body>
</html>