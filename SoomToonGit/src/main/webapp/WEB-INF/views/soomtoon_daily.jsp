<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요일별 웹툰</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/soomtoon_daily.css"/>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$(".daily-text").click(function(){
		let dayWeek = $(this).data('day'); 
		// 클릭한 요일의 day 값을 뽑음
		
		$(".daily-text").show();
		$(".daily-subtab-check").hide();
		
		$(this).hide();
		$(".daily-subtab-check[data-day='" + dayWeek + "']").show();
		
		location.href="${pageContext.request.contextPath}/main?day_week=" + dayWeek;
		
	});	
	
	$(".content-img").click(function(){
		let idx = $(this).attr("data-toonIdx");
		location.href = "${pageContext.request.contextPath}/webtoonContent?webtoonIdx=" + idx;
	});
		
	$("#rank").click(function(){
		location.href="${pageContext.request.contextPath}/soomtoon_rank";
	
	});
	
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
	 
}); /* $(function) 마지막 중괄호 */



$(document).ready(function() {
    // selectedDay 값에 따라 해당 요일을 표시
    let selectedDay = "${day_week}";

    // 선택된 요일에 해당하는 .daily-subtab-check를 표시하고, .daily-text는 숨김
    $(".daily-text[data-day='" + selectedDay + "']").hide();
    $(".daily-subtab-check[data-day='" + selectedDay + "']").show();
});
</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="full-box">
	<div class="full-body">
		<div class="nav-box">
			<div class="nav-layout">
				<ul class="nav-ul">
					<li class="nav-li">
						<div style="display: none" class="nav-text-box">
							<span class="nav-text">요일</span>
						</div>
						<div class="nav-text-box-checked">
							<img width="32" height="32"src="data:image/png;base64,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"/>
							<span class="nav-text">요일</span>
						</div>
					</li>
					<li class="nav-li">
						<div  class="nav-text-box">
							<span class="nav-text" id="rank">실시간 랭킹</span>
						</div>
						<div style="display: none" class="nav-text-box-checked">
							<img width="32" height="32"src="data:image/png;base64,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"/>
							<span class="nav-text">실시간 랭킹</span>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="content-box">
			<div class="daily-tab">
				<div class="daily-subtab">
					<div style="display: none" class="daily-subtab-check" data-day="1">월</div>
					<span class="daily-text" data-day="1">월</span>
					<div style="display: none"  class="daily-subtab-check" data-day="2">화</div>
					<span class="daily-text" data-day="2">화</span>
					<div style="display: none"  class="daily-subtab-check" data-day="3">수</div>
					<span class="daily-text" data-day="3">수</span>
					<div style="display: none"  class="daily-subtab-check" data-day="4">목</div>
					<span class="daily-text" data-day="4">목</span>
					<div style="display: none"  class="daily-subtab-check" data-day="5">금</div>
					<span class="daily-text" data-day="5">금</span>
					<div style="display: none"  class="daily-subtab-check" data-day="6">토</div>
					<span class="daily-text" data-day="6">토</span>
					<div style="display: none" class="daily-subtab-check" data-day="7">일</div>
					<span class="daily-text" data-day="7">일</span>
				</div>
			</div>
			<div class="daily-count">요일별 웹툰수 (${countToon})</div>
			<div class="content-layout">
				<div class="content-layout-inner">
				<c:if test="${not empty list }">
					<c:forEach var="dto" items="${list}">
						<div class="content">
							<img class="content-img" data-toonIdx="${dto.webToon_idx }" src="${dto.toon_img }"/>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty list }"	>
					<p>해당 요일의 웹툰이 없습니다.</p>
				</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 챗봇 아이콘 -->
<c:if test="${not empty sessionScope.userId}">
	<div id="chatbot-icon">soomChat</div>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>
<!-- <script type="text/javascript" src="resources/js/soomtoon_daily.js"></script> -->
</body>
</html>