<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 탈퇴</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/account_infor.css"/>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		
		$(".check-box-inner").click(function(){
			let checkbox = $(this).find('input[type="checkbox"]');
			
			if(checkbox.is(':checked')){
				$("#check-after").show();
				$("#check-before").hide();
				$(".withdrawal").css('background-color','rgb(255, 188, 0)');
				$(".withdrawal").css('color','black');
				$(".withdrawal").css('cursor', 'pointer');
				$(".withdrawal").prop("disabled", false);
			} else {
				$("#check-after").hide();
				$("#check-before").show();
				$(".withdrawal").css('background-color','rgb(238,238,238)');
				$(".withdrawal").css('color','rgb(224,224,224)');
				$(".withdrawal").prop("disabled", true);
			}
		});
		
		$(".withdrawal").click(function(){
			if($(".check-box-inner input[type='checkbox']").is(':checked')){
				if(confirm("정말로 탈퇴하시겠습니까?")){
					$("#deleteForm").submit();
				}
			} 
		});
		
	});  // function() 마지막 중괄호

</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="full-box">
	<div class="full-body">
		<div class="content-layout">
			<div class="content-header">
				<span class="header-text">
					카카오페이지 탈퇴 전 <br>
					아래 주의사항을 꼭 확인해 주세요.
				</span>
			</div>
			<div class="content-box">
				<div class="conten-inner-box">
					<span class="content-text">
						탈퇴 시 카카오페이지, 스테이지사이트 서비스 이용이 불가합니다.
					</span>
				</div>
				<div class="conten-inner-box">
					<span class="content-text">
						탈퇴 시 회원님의 구매 이력 확인과 유료 콘텐츠에 대한 이용 및 재다운로드 권한이 상실되고, 재가입 시에도 복구가 불가능합니다.
					</span>
				</div>
				<div class="conten-inner-box">
					<span class="content-text">
						탈퇴 후 미사용 이용권의 구매 취소는 불가능하니, 탈퇴 전에 이용권 구매 취소 메뉴를 통해 환불을 진행하시기 바랍니다.
					</span>
				</div>
				<div class="conten-inner-box">
					<span class="content-text">
						탈퇴 시 회원님이 보유하셨던 캐시는 소멸되며, 소멸된 캐시는 복원 및 환불되지 않습니다. 유료로 구입한 캐시 중, 사용하지 않은 잔여 캐시가 있는 경우, 탈퇴 전 고객센터를 통해 환불을 진행해 주시기 바랍니다.					
					</span>
				</div>
				<div class="conten-inner-box">
					<span class="content-text">
						카카오페이지 서비스를 탈퇴하더라도 카카오페이지에 등록한 댓글과 별점은 유지됩니다. 스테이지에 올린 댓글과 작품 역시 유지되며 닉네임만 삭제됩니다. 카카오페이지와 스테이지에서 등록한 댓글 및 작품의 삭제를 원하시는 경우, 탈퇴 전 삭제해 주시기 바랍니다.
					</span>
				</div>
				<div class="conten-inner-box">
					<span class="content-text">
						카카오페이지 서비스 탈퇴는 카카오 계정 및 카카오톡 서비스 탈퇴와는 무관합니다.
					</span>
				</div>
				<div class="conten-inner-box">
					<span class="content-text">
						탈퇴 후 7일 동안은 동일한 카카오 계정으로 재가입할 수 없습니다. 정상적이지 않은 가입과 탈퇴의 반복을 차단하고 선량한 이용자들에게 피해를 끼치는 행위를 방지하기 위한 정책으로 많은 양해 부탁드립니다.
					</span>
				</div>
			</div>
			<form id="deleteForm" action="${pageContext.request.contextPath}/account_delete" method="post">
				<input type="hidden" name="user_idx" value="${user_idx}" />
				<div class="check-box">
					<label class="check-box-inner">
						<div class="check-box-check">
							<input type="checkbox" class="check-box-check-ab" />
							<img id="check-before" src="data:image/svg+xml,%3csvg width='18' height='18' viewBox='0 0 18 18' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cpath d='M18 9C18 13.9706 13.9706 18 9 18C4.02944 18 0 13.9706 0 9C0 4.02944 4.02944 0 9 0C13.9706 0 18 4.02944 18 9Z' fill='%23EEEEEE'/%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M14.1364 6.6364L8 12.7728L3.8636 8.6364L5.1364 7.3636L8 10.2272L12.8636 5.3636L14.1364 6.6364Z' fill='%237A7A7A'/%3e %3c/svg%3e"/>
							<img style="display: none" id="check-after" src="data:image/svg+xml,%3csvg width='18' height='18' viewBox='0 0 18 18' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cg clip-path='url(%23clip0_5192_46937)'%3e %3cpath d='M18 9C18 13.9706 13.9706 18 9 18C4.02944 18 0 13.9706 0 9C0 4.02944 4.02944 0 9 0C13.9706 0 18 4.02944 18 9Z' fill='%23FFBC00'/%3e %3cpath fill-rule='evenodd' clip-rule='evenodd' d='M14.1364 6.6364L8 12.7728L3.8636 8.6364L5.1364 7.3636L8 10.2272L12.8636 5.3636L14.1364 6.6364Z' fill='%23222222'/%3e %3c/g%3e %3cdefs%3e %3cclipPath id='clip0_5192_46937'%3e %3crect width='18' height='18' fill='white'/%3e %3c/clipPath%3e %3c/defs%3e %3c/svg%3e"/>
						</div>
						<span class="check-text">
							안내 사항을 모두 확인했으며, 탈퇴 시 회원 정보는 모두 삭제되고 데이터 복구가 불가함에 동의합니다.
						</span>
					</label>
				</div>
				<button class="withdrawal" disabled>
					카카오페이지 탈퇴
				</button>
			</form>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>