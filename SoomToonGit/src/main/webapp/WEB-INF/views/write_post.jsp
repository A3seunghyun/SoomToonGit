<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/write_post.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/write_post.js" defer></script>
<script>
    let contextPath = "<%= request.getContextPath() %>";
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="write_container">
		<h1>게시글 작성</h1>
		<form class="write_form" action="${pageContext.request.contextPath}/writePost" method="post">
			<label class="write_label" for="webtoon_name">웹툰명:</label>
			<input type="text" id="webtoon_name" name="webtoon_name" value="" readonly style="pointer-events: auto;">
			<input type="hidden" id="webtoon_name_value" name="webtoonIdx" value="">
		
			<label class="write_label" for="title">제목:</label>
			<input type="text" id="title" name="postTitle">

			<label class="write_label" for="author">작성자:</label>
			<input type="text" id="author" name="author" value="${userInfo.alias }" readonly>
			<input type="hidden" id="author_value" name="userIdx" value="${userInfo.user_idx }">

			<label class="write_label" for="content">내용:</label>
			<textarea style="resize: none;" id="content" name="postContent" rows="10"></textarea>

			<button type="submit" class="submit-btn">작성 완료</button>
		</form>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- 모달 -->
	<div id="webtoonModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>웹툰명 검색</h2>
			<input type="text" id="webtoonName" name="webtoonName" placeholder="웹툰명 검색">
			<button class="search-btn" id="search-btn">검색</button>
			
			<!-- 검색 결과 목록 -->
			<div class="results" id="results">
				<div id="resultCount" style="font-size: 14px;"></div>
				<select id="webtoonSelect">
					<option value="">웹툰을 선택하세요</option>
			    </select>
			</div>
			<button class="search-btn" id="check-btn" style="float: right; width: 100%;">확인</button>
		</div>
	</div>
	
	<script type="text/javascript" src="resources/js/free-bulletin-board.js" defer></script>
</body>
</html>