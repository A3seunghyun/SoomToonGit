		<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보관함 웹툰</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/soomtoon_zzim.css"/>
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
	
	$(".content").click(function(){
		let idx = $(this).find(".content-img").attr("data-toonIdx");
		location.href = "${pageContext.request.contextPath}/webtoonContent?webtoonIdx=" + idx;
	});
		
	$("#rank").click(function(){
		location.href="${pageContext.request.contextPath}/soomtoon_rank";
	
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
						<div class="nav-text-box-checked">
							<span class="nav-text">보관함</span>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="content-box">
			<div class="daily-count">보관함 웹툰수 (${zzimCount})</div>
			<div class="content-layout">
				<div class="content-layout-inner">
				<c:if test="${not empty list }">
					<c:forEach var="dto" items="${list}">
						<div class="content">
							<img class="content-img" data-toonIdx="${dto.webToon_idx }" src="${dto.toon_img }"/>
							<div class="content-title">${dto.toon_name }</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty list }"	>
					<p style="font-size:14px;">보관된 웹툰이 없습니다.</p>
				</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 챗봇 아이콘 -->
<jsp:include page="chat_bot.jsp"></jsp:include>

<jsp:include page="footer.jsp"></jsp:include>
<!-- <script type="text/javascript" src="resources/js/soomtoon_daily.js"></script> -->
</body>
</html>