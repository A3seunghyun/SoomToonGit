<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocket - chat</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<script>
	let name;
	let ws;
	const url = 'ws://localhost:9090/soomtoon/chatserver.do';
	
	function connect(name, toonName) {
		
		window.name = name;
		$('#header small').text(name);
		
		window.toonName = toonName;
// 		alert(toonName);
		$('#toonName').text(toonName);
		
		
		ws = new WebSocket(url);
		
		ws.onopen = function(evt) {
			
			let message = {
					code: '1',
					sender: window.name,
					receiver: '',
					content: '',
					regdate: new Date().toLocaleString()
			};
			
			ws.send(JSON.stringify(message));
			print('', '대화방에 참여했습니다.' , 'me', 'state', message.regdate);
			
			$('#msg').focus();
		};
		
		ws.onmessage = function(evt) {
			
			let message = JSON.parse(evt.data);
			console.log(message);
			
			if (message.code == '1') {
				print('', `[\${message.sender}]님이 들어왔습니다.`, 'other', 'state', message.regdate);
			} else if (message.code == '2') {
				print('', `[\${message.sender}]님이 나갔습니다.`, 'other', 'state', message.regdate);
			} else if (message.code == '3') {
				print(message.sender, message.content, 'other', 'msg', message.regdate);
			} else if (message.code == '4') {
				printEmoticon(message.sender, message.content, 'other', 'msg', message.regdate);
			}
		}
	}//connect
	
	function log(msg) {
		console.log(`[\${new Date().toLocaleTimeString()}] \${msg}`);
	}
	
	function print(name, msg, side, state, time) {
		let temp = `
			<div class="item \${state} \${side}">
				<div>
					<div>\${name}</div>
					<div>\${msg}</div>
				</div>
				<div>\${time}</div>
			</div>`;
		
		$('#list').append(temp);
		
		//새로운 내용이 추가되면 스크롤을 바닥으로 내린다.
		scrollList();
	}
	
	$(window).on('beforeunload', function() {
		disconnect();
	});
	
	function disconnect() {
		let message = {
				code: '2',
				sender: window.name,
				receiver: '',
				content: '',
				regdate: new Date().toLocaleString()
		};
		
		ws.send(JSON.stringify(message));
	}
	
	//대화 스크롤 이벤트
	function scrollList() {
		$('#list').scrollTop($('#list').outerHeight() + 300);
	}

	
$(document).ready(function(){
	 // 전송 함수 (엔터키와 전송 버튼에서 호출)
    function sendMessage() {
        let message = {
            code: '3',
            sender: window.name,
            receiver: '',
            content: $('#msg').val(),
            regdate: new Date().toLocaleString()
        };

        if ($('#msg').val().startsWith('/')) {
            message.code = '4';
        }

        ws.send(JSON.stringify(message));
        $('#msg').val('').focus();

        if (message.code == '3') {
            print(window.name, message.content, 'me', 'msg', message.regdate);
        } else if (message.code == '4') {
            printEmoticon(window.name, message.content, 'me', 'msg', message.regdate);
        }
    }

    // 엔터 키 이벤트
    $('#msg').keydown(function(evt) {
        if (evt.keyCode == 13) {  // 엔터키
            sendMessage();
            evt.preventDefault(); // 엔터키로 인한 줄바꿈 방지
        }
    });

    // 전송 버튼 클릭 이벤트
    $('#sendBtn').click(function() {
        sendMessage();
    });
});	
</script>

<body>
	<div id="main">
		<div id="header"><h2>WebSocket <small>닉네임</small> <small id="toonName" style="font-size: 12px; color:rgb(240, 150, 5);">툰네임</small></h2></div>
		<div id="list">
			
		</div>
		<input type="text" id="msg" placeholder = "대화 내용을 입력하세요.">
		<button id="sendBtn">전송</button> <!-- 전송 버튼 추가 -->
	</div>
	
</body>
</html>