<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chat-bot</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat_bot.css"/>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#chatbot-icon").click(function(){
		
	// 닉네임 입력하기 위한 창, Guest는 기본값
	let name = prompt("닉네임을 입력하세요:", "Guest");
		if (name) {
			let contextPath = "${pageContext.request.contextPath}";
			let child = window.open(contextPath +'/chat.do', 'chat', 'width=405,height=510');
		   
			child.addEventListener('load', function() {
		   	// 새 창이 완전히 로드된 후 이벤트 발생함
		       if (typeof child.connect === 'function') {
		      		// typeof 값의 타입을 확인할때 쓰는 연산자 connect가 함수인지, chat.do에 connect함수가 있는지ㅋ
		           child.connect(name);
		       } else {
		           console.error("connect 함수가 정의되지 않았습니다.");
		       }
		       
		       if(name.equals("")) {
		       	alert("닉네임을 입력하세요");
		       } 
		   });
		}
	});
});
</script>
<body>

<!-- 챗봇 아이콘 -->
<c:if test="${not empty sessionScope.userId}">
	<div id="chatbot-icon">soomChat</div>
</c:if>

</body>
</html>