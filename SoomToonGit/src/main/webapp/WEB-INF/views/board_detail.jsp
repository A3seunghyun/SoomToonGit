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
		<h1>${boardDetail[0].title }</h1>
		<div class="post-info">
			<span class="author">작성자: ${boardDetail[0].userName }</span>
			<span class="date">작성일: ${boardDetail[0].postDate }</span>
			<span class="views">조회수: ${boardDetail[0].postView }</span>
			<span class="comments">댓글수: 구현중</span>
		</div>
		<hr>
		<div class="post-content">
			<p>${boardDetail[0].postContent }</p>
		</div>
		<hr>
		<button class="back-btn" id="back-btn">목록으로</button>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>