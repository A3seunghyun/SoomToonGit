<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/account_infor.css"/>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		let alias = $(".alias-input").val();
		$(".alias-input").keyup(function(){
			let aliasStr = $(this).val();
			  if(alias === aliasStr || aliasStr.length <= 1) {
      			  // 닉네임이 같거나 1 이하일 때 버튼 비활성화
		        $(".save").css({"background":"rgb(238, 238, 238)", "color":"rgb(224, 224, 224)"});
      			$(".save").prop("disabled", true); 
		    } else {
		        // 닉네임이 다르고 길이가 2자 이상일 때 버튼 활성화
		        $(".save").css({"background":"rgb(255, 188, 0)", "color":"black", "cursor":"pointer"});
		        $(".save").prop("disabled", false);
		    }
		});
		
	function textLength(){
		let alias = $(".alias-input").val();
		let aliasLength = alias.length;
		let maxLength = 16;
		
		$(".text-length").text(aliasLength);
		$(".text-length2").text("/" + maxLength);
	}
	$(".alias-input").keyup(textLength);
	textLength();
	
	
	});  //jQuery 마지막 중괄호
	
</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="full-box">
	<div class="full-body">
		<span class="account-infor">
			프로필수정
		</span>
		<div class="update-layout">
			<div class="update-inner-layout">
				<form action="${pageContext.request.contextPath}/profile_update" method="post">
					<input type="hidden" name="user_idx" value="${userInfo.user_idx }"/>
					<div class="alias-text-box">
						<span class="alias-text">닉네임을 입력해주세요</span>
						<span class="text-length"></span>
						<span class="text-length2">/16</span>
					</div>
					<div class="alias-update-box">
						<div class="alias-update-inner-box">
							<div class="items-center">
								<input class="alias-input" name="alias" size="1" value="${userInfo.alias }" maxlength="15"/>
								<button>
									<img class="x-button" src="data:image/svg+xml,%3csvg width='12' height='12' viewBox='0 0 12 12' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M6 12C9.31371 12 12 9.31371 12 6C12 2.68629 9.31371 0 6 0C2.68629 0 0 2.68629 0 6C0 9.31371 2.68629 12 6 12ZM7.94454 9.0052L6 7.06066L4.05546 9.0052L2.9948 7.94454L4.93934 6L2.9948 4.05546L4.05546 2.9948L6 4.93934L7.94454 2.9948L9.0052 4.05546L7.06066 6L9.0052 7.94454L7.94454 9.0052Z' fill='%23999999'/%3e %3c/svg%3e"/>
								</button>
							</div>
						</div>
					</div>
					<input type="submit" class="save"  value="저장" disabled />
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>