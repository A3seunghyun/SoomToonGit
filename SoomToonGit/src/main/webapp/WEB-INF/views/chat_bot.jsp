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
$(function() {
    $("#chatbot-icon").click(function() {
        let name = prompt("닉네임을 입력하세요:", "Guest");

        if (name && name.trim() !== "") {
            $("#nickname").text(name); // 닉네임 설정
            $("#chat-list-container").show(); // 채팅방 목록 표시
            $("#chatbot-icon").hide();	// 챗봇 숨김
        } else {
            alert("닉네임을 입력하세요");
        }
    });

    // 닫기 버튼 클릭 시 채팅방 목록 숨기고 챗봇아이콘 나타나기
    $("#close-chat-list").click(function() {
        $("#chat-list-container").hide();
        $("#chatbot-icon").show();
    	$(".toon-search").val("");
    	$(".toonList").empty().hide();
    });
    
    
    $(".toon-search").on("input", function(){
		let toonName = $(this).val().trim();
		
		//검색어가 없으면 toonList 숨김
		if(toonName === "") {
			$(".toonList").empty().hide();
			return;
		}
		
		let result = $(".toonList"); // 데이터를 추가할 div 선택
		
		$.ajax({
			url: '${pageContext.request.contextPath}/ajax/searchToonList',
			type: 'POST',
			dataType: 'json',
			contentType: 'application/json; charset=UTF-8',
			data: JSON.stringify({"toonName": toonName}),
			success: function(list){
				
					result.empty();
					console.log(list);
				
				if (list.length > 0) {
					list.forEach(function(toon){
						
						result.append('<div class="toonList" data-toon-idx="' + toon.webToon_idx + '">' + toon.toon_name + '</div>');

					});
					result.show();
				} else {
					result.append("<div>검색결과가 없습니다.<div>");
					result.show();
				}
			},
			error: function(error) {
				alert("오류발생");
			}
		});
	});
    
    
	$(document).on("click", ".toonList",  function(){
		   // #nickname 요소에서 텍스트를 가져옴
	     let name = $("#nickname").text();
	     let toonName = $(this).text().trim();
		   
	     console.log("닉네임 : ", name);  
	     console.log("툰 네임 : ", toonName);
	     
	     if (name && name.trim() !== "") {
		let contextPath = "${pageContext.request.contextPath}";
		let child = window.open(contextPath +'/chat.do', 'chat', 'width=405,height=510');
	
		child.addEventListener('load', function() {
	   	// 새 창이 완전히 로드된 후 이벤트 발생함
	       if (typeof child.connect === 'function') {
	      		// typeof 값의 타입을 확인할때 쓰는 연산자 connect가 함수인지, chat.do에 connect함수가 있는지ㅋ
	           child.connect(name,toonName);
	       } else {
	           console.error("connect 함수가 정의되지 않았습니다.");
	       }
	   });s
		} 
		else {
			alert("닉네임을 입력하세요")
		}
	 	
	});
    
}); // $(function) 마지막 중괄호 

	
</script>
<body>

	<!-- 챗봇 아이콘 -->
	<c:if test="${not empty sessionScope.userId}">
		<div id="chatbot-icon">soomChat</div>
	</c:if>

	<!-- 채팅방 목록 -->
	<div id="chat-list-container" style="display: none;">
	    <div class="chat-header">
	        <h2>soomChat (<span id="nickname"></span>)</h2>
	        <button id="close-chat-list">닫기</button>
	    </div>
	    <div class="chat-rooms">
	    	<input class="toon-search" type="text" placeholder="웹툰을 검색하세요"/>
            <div class="toonList" data-toon-idx= ""><span></span></div>
<!-- 	        <ul> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	            <li>채팅방목록 1</li> -->
<!-- 	        </ul> -->
	    </div>
	</div>


</body>
</html>