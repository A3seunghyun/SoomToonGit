<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signUp.css"/>
<title>회원가입</title>
</head>
<body>
<script type="text/javascript" src="resources/js/main.js"></script>
<jsp:include page="header.jsp"></jsp:include>
<form action="" method="post">
	<div id="signUp-box">
		<div id="signUp-header">
			<a href="메인페이지">
				<img class="header-img" src="resources/img/Soomtoon_logo.png"/>
			</a>
		</div>
		<div class="content_box">
<!-- 			<div> -->
				<h2 id="id2">자스자스자스</h2>
				<h5>아이디</h5>
				<input type="text" name="id" id="id"/>
<!-- 				<select> -->
<!-- 					<option value="1">naver.com</option> -->
<!-- 					<option value="1">daum.net</option> -->
<!-- 					<option>yahoo.com</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
			<h5>비밀번호</h5>
			<input type="text" name="pw" id="pw"/>
			<h5>이름</h5>
			<input type="text" name="name" id="name"/>
			<h5>주민번호</h5>
			<input type="text" name="jumin" id="jumin"/>
			-
			<input type="text" name="jumin2" id="jumin2"/>
			<div id="btn-box">
				<input class="signUp-btn" type="submit" value="가입하기"/>
			</div>
		</div>
	</div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>