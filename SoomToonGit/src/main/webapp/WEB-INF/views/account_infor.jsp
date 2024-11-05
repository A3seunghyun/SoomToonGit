<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 정보</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/account_infor.css"/>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#nickname").click(function(){
			// 프로필 수정 창으로 이동
			location.href = "${PageContext.request.contextPath}/soomtoon/profile_updateForm?user_idx=" + ${user_idx};
		});
		$("#widthdrawal").click(function(){
			//서비스 탈퇴창으로 이동
			location.href = "${PageContext.request.contextPath}/soomtoon/service_withdrawal?user_idx=" + ${user_idx};
		});
		
	});
</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="full-box">
	<div class="full-body">
		<span class="account-infor">
			계정 정보
		</span>
		<div class="alias-layout">
			<div class="alias-box">
				<div class="alias-innerBox" id="nickname">
					<span class="alias">닉네임</span> 
					<span class="name">${dto.alias}</span>
				</div>
				<img width="24" height="24" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M8.5 16.9466L13.5343 12L8.5 7.05338L9.39371 6L15.5 12L9.39371 18L8.5 16.9466Z' fill='%23222222'/%3e %3c/svg%3e"/>
			</div>
			<div class="under-line"></div>
		</div>
		<div class="alias-layout">
			<div class="alias-box">
				<div class="alias-innerBox">
					<span class="alias">주민 앞자리</span> 
					<span class="name">${dto.jumin1}</span>
				</div>
			</div>
			<div class="under-line"></div>
		</div>
		<div class="alias-layout">
			<div class="alias-box">
				<div class="alias-innerBox" id="widthdrawal">
					<span class="name">서비스 탈퇴</span>
				</div>
				<img width="24" height="24" src="data:image/svg+xml,%3csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M8.5 16.9466L13.5343 12L8.5 7.05338L9.39371 6L15.5 12L9.39371 18L8.5 16.9466Z' fill='%23222222'/%3e %3c/svg%3e"/>
			</div>
			<div class="under-line"></div>
		</div>
	</div>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>