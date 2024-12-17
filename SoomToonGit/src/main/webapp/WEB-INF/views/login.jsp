<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/login.js" defer></script>
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded", function(){
		<c:if test="${not empty errorMessage}">
			alert('${errorMessage}'); // 오류 메시지 표시
		</c:if>
	});
</script>

<!-- 카카오 로그인 -->
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<script type="text/javascript">
    $(document).ready(function(){
        Kakao.init('script앱키 입력');
        Kakao.isInitialized();
    });

    function loginWithKakao() {
        Kakao.Auth.authorize({ 
        redirectUri: 'http://localhost:9090/kakao_callback' 
        }); // 등록한 리다이렉트uri 입력
    }
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="login-container">
		<h2>로그인</h2>
		<form action="login" method="post">
			<table class="login-table">
				<tr>
					<td><label for="username">아이디</label></td>
					<td><input type="text" id="username" name="id" placeholder="아이디를 입력하세요"></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호</label></td>
					<td><input type="password" id="password" name="pw" placeholder="비밀번호를 입력하세요"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" id="login-btn" class="login-btn">로그인</button>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="join-member" class="login-btn">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
<!-- =================== 카카오 로그인  ==================-->
		<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=6259e8667002337b0fccfd09aec1ce35&redirect_uri=http://localhost:9090/soomtoon/login">
			<img src="<%= request.getContextPath() %>/resources/img/kakao_login_large_narrow.png" alt="카카오 로고" style="width: 170px; height: auto; padding: 10px; display: block; object-fit: contain;" />
		</a>

	</div>
</body>
</html>