<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/soomtoon_insert.css"/>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		let postTitle = $("#post-title");
		let content = $("#content");
		let submit = $(".submit-btn");
		
		function checkInput() {
			if(postTitle.val().trim() !== "" && content.val().trim() != "") {
				submit.css("color", "#f09605");
			} else {
				submit.css("color", " rgb(197, 197, 197)")
			}
		}
		postTitle.on("input", checkInput);
		content.on("input",checkInput);
		
		checkInput();
	});
</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="full-box">
	<div class="full-body">
		<form>
			<div class="input-header">
				<input type="submit" class="submit-btn" name="submit" value="등록"/>
			</div>
			<div class="webtoon-title-box">
				<input type="text" id="webtoon-title" name="webtoon-title" readonly value="웹툰명"/>
			</div>
			<div class="title-input">
				<input type="text" id="post-title" name="post-title" placeholder="제목을 입력해주세요."/>
			</div>
			<div class="content-input">
				<textarea id="content" name="content" placeholder="내용을 입력하세요"></textarea>
			</div>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>