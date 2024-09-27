<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/board_detail.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board_detail.js" defer></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<h1>나 혼자만 레벨업 최신화 빨리 내놔!!!!</h1>
		<div class="post-info">
			<span class="author">작성자: 장용준</span>
			<span class="date">작성일: 2024-09-26</span>
			<span class="views">조회수: 777</span>
			<span class="comments">댓글수: 77</span>
		</div>
		<hr>
		<div class="post-content">
			<p>최신화 언제 올라오나요? 기다리다 목 빠질 것 같아요!!!</p>
		</div>
		<hr>
		<button class="back-btn" id="back-btn">목록으로</button>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>