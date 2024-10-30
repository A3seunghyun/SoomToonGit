<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/write_post.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="write_container">
		<h1>게시글 작성</h1>
		<form class="write_form" method="post">
			<label class="write_label" for="webtoon_name">웹툰명:</label>
			<input type="text" id="webtoon_name" name="webtoon_name" readonly required>
		
			<label class="write_label" for="title">제목:</label>
			<input type="text" id="title" name="title" required>

			<label class="write_label" for="author">작성자:</label>
			<input type="text" id="author" name="author" value="${userInfo.alias }" readonly>

			<label class="write_label" for="content">내용:</label>
			<textarea style="resize: none;" id="content" name="content" rows="10" required></textarea>

			<button type="submit" class="submit-btn">작성 완료</button>
		</form>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="resources/js/free-bulletin-board.js" defer></script>
</body>
</html>