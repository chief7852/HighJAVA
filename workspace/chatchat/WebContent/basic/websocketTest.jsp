<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<!-- 메시지 표시 영역 -->
	<textarea id="messageTextArea" readonly="readonly" rows="10" cols="45"></textarea>
	<br>

	<!-- 송신 메시지 텍스트박스 -->
	<!-- 처음 보내는 메시지는 사용자 이름을 입력하여 보낸다.  -->
	<input type="text" id="messageText" size="50">

	<!-- 송신 버튼 -->
	<input type="button" value="Send" onclick="sendMessage()">

	<div id="mem">
	
	</div>
	
	<script type="text/javascript">
		//웹소켓 초기화 (웹소켓 URI 주소 : ws://서버주소/컨텍스트이름(프로젝트명)/웹소켓서비스명
		var webSocket = new WebSocket("ws://localhost:8032/chatchat/basicsocket");

		var messageTextArea = document.getElementById("messageTextArea");

		//메시지가 오면 messageTextArea요소에 메시지를 추가한다.
		webSocket.onmessage = function processMessge(message) {
			
			//Json 풀기
			var jsonData = JSON.parse(message.data);
			if (jsonData.message != null) {
				messageTextArea.value += jsonData.message + "\n"
			}
			;
		}

		//메시지 보내기
		function sendMessage() {
			var messageText = document.getElementById("messageText");
			webSocket.send(messageText.value);
			messageText.value = "";
		}
	</script>
	<script type="text/javascript">
$(function() {
				var messageText = document.getElementById("messageText");
			$('#messageText').keydown(function(key) {
				if (key.keyCode == 13) {
					webSocket.send(messageText.value);
					messageText.value = "";
				}
			});
			$('#btn-submit').click(function() {
				webSocket.send(messageText.value);
				messageText.value = "";
			});

		})
	</script>
</body>
</html>