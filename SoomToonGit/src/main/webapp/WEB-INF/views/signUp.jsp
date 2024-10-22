<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signUp.css"/>
<title>회원가입</title>
</head>
<body>
<script type="text/javascript" src="resources/js/signUp.js"></script>
<script>
window.addEventListener('DOMContentLoaded', function () {
	// HTML이 완전히 준비된 후에 아래의js코드가 실행되도록 보장.
	// HTML 문서가 완전히 로드되지 않은 상태에서 js 실행시 오류 발생 방지
	  let jumin1 = document.getElementById("jumin1");
	  let value = '';
	// 주민 뒷자리 값을 공백으로 잡아놓음
	
// 	주민 앞자리 유효성 검사
	function validateJumin1(jumin1) {
	  	let input = jumin1.value;
	  	let number = /[^0-9]/g;  // 숫자 이외의 문자를 확인하는 정규표현식
		
	  	// 입력값에 숫자가 아닌 문자가 포함되어 있으면 제거
	    if (number.test(input)) {
	    	alert("숫자를 입력해주세요.");
	    	jumin1.value = input.replace(number, "");
	    	return false;
	    }

	  	// 입력값이 6글자가 아니면 오류 메시지 출력
	  	if (input.length !== 6) {
	  		alert("주민번호 앞자리는 숫자 6글자여야 합니다.");
	  		return false;
	  	}
	  	return true;
	}
	
	// 주민 뒷자리 유효성 검사
	function validateJumin2(jumin2) {
	    let input = jumin2.value;
	    let number = /[^0-9]/g;  // 숫자 이외의 문자를 확인하는 정규표현식
	    value = input;

	    // 숫자가 아닌 문자가 포함되어 있으면 제거
		if (number.test(input)) {
			alert("숫자를 입력해주세요.");
			jumin2.value = input.replace(number, "");
			return false;
		}

		// 입력값이 7글자가 아니면 오류 메시지 출력
		if (input.length !== 7) {
			alert("주민번호 뒷자리는 7글자여야 합니다.");
			return false;
		}
		return true;
	}
	
//	비밀번호 유효성 검사 함수
	function validatePassword(password) {
	    const minLength = 8;
	    const uppercaseRegExp = /[A-Z]/;
	    const lowercaseRegExp = /[a-z]/;
	    const numberRegExp = /[0-9]/;
	    const specialCharRegExp = /[!@#$%^&*(),.?":{}|<>]/;
	
	    if (password.length < minLength) {
	        alert("비밀번호는 최소 8자 이상이어야 합니다.");
	        return false;
	    }
	    if (!uppercaseRegExp.test(password)) {
	        alert("비밀번호에는 대문자가 하나 이상 포함되어야 합니다.");
	        return false;
	    }
	    if (!lowercaseRegExp.test(password)) {
	        alert("비밀번호에는 소문자가 하나 이상 포함되어야 합니다.");
	        return false;
	    }
	    if (!numberRegExp.test(password)) {
	        alert("비밀번호에는 숫자가 하나 이상 포함되어야 합니다.");
	        return false;
	    }
	    if (!specialCharRegExp.test(password)) {
	        alert("비밀번호에는 특수 문자가 하나 이상 포함되어야 합니다.");
	        return false;
	    }
	    return true;
	}
	
//	아이디 휴효성 검사 (영어 소문자, 숫자만)
	function userId(userId) {
		let lowercase = /^[a-z0-9]+$/;
		if(!lowercase.test(userId)){
			alert("아이디는 영어 소문자와 숫자만 포함할 수 있습니다.");
			return false;
		}
		return true;
	}
	
// 	이름 유효성 검사 (한글 두글자 이상)
	function userNmae(name) {
// 		let nameExr = /^[a-zA-Z가-힣\s]+$/;
		let nameExr = /^[가-힣\s]+$/;
		let minLength = 2;
		let maxLength = 50;
		
		if(name.length < minLength || name.length > maxLength) {
			alert("이름은 최소 2글자이상, 최대 50글자 이내여야 합니다");
			return false;
		}
		if(!nameExr.test(name)){
			alert("이름에 한글만 사용 할 수 있습니다");
			return false;
		}
		return true;
	}
	
// 	닉네임 유효성 검사 (두글자 이상)
	function userAlias(alias) {
		let aliasExr = /^[a-zA-Z가-힣\s]+$/;
		let minLength = 2;
		let maxLength = 50;
		
		if(alias.length < minLength || alias.length > maxLength) {
			alert("alias 최소 2글자이상, 최대 50글자 이내여야 합니다");
			return false;
		}
		return true;
	}
	
	// 회원가입 유효성 검사
	function addCheck() {
		if (frm.id.value.length === 0) {
			alert("아이디가 입력되지 않았습니다");
			frm.id.focus();
			return false;
		} else if (!userId(frm.id.value)) {
			frm.id.focus();
			return false;
		}

		// 비밀번호 검사
		if (!validatePassword(frm.pw.value)) {
			frm.pw.focus();
			return false;
		}

		if (frm.name.value.length === 0) {
			alert("이름이 입력되지 않았습니다");
			frm.name.focus();
			return false;
		} else if (!userNmae(frm.name.value)) {
			frm.name.focus();
			return false;
		}
		
		if (frm.alias.value.length === 0) {
			alert("닉네임이 입력되지 않았습니다");
			frm.alias.focus();
			return false;
		} else if (!userAlias(frm.alias.value)) {
			frm.alias.focus();
			return false;
		}
		// 주민번호 앞자리 검사
		if (!validateJumin1(jumin1)) {
			jumin1.focus();
			return false;
		}

		// 주민번호 뒷자리 검사
		if (!validateJumin2(jumin2)) {
			jumin2.focus();
			return false;
		}

		alert("회원가입이 완료되었습니다");
		return true;
	}

	// 회원가입 폼 제출 시 유효성 검사
	document.forms['frm'].onsubmit = function () {
		return addCheck();
	};
	
	let id = document.getElementById("id");
	id.addEventListener("focusout",function(){
		let idVal = document.getElementById("id").value;
		let contextPath = '${pageContext.request.contextPath}';
		console.log("입력값:", idVal);
		if( idVal === '' || idVal.length == 0 || idVal.includes(' ')) {
			// ID가 공백, 0, 문자열 사이 공백이면 ID생성 불가.
			let label1 = document.getElementById("label1");
			label1.style.color = "red"; 
			label1.textContent = "공백은 ID로 사용할 수 없습니다.";
			
			return false;
		}
		
	  // Ajax 요청
		$.ajax({
		    url: contextPath + '/ajax/ConfirmId',
		    data: JSON.stringify({"id": idVal}),  // JSON으로 id 데이터를 전송
		    type: 'POST',
		    contentType: 'application/json; charset=UTF-8',  // JSON 형식으로 전송
		    dataType: 'json',  // 서버에서 JSON 형식의 응답을 기대
		    success: function(result) {
		        console.log("Ajax 성공, 서버에서 받아온 값: " + result); 
		        let label1 = $("#label1");
		        if (result === true) {  // 아이디 중복일 때
		            label1.css("color", "red");
		            label1.text("사용 불가능한 ID 입니다");
		            $("#id").val('');  // 불가능한 ID일 경우 ID 필드 초기화
		        } else if (result === false) {  // 사용 가능한 아이디일 때
		            label1.css("color", "black");
		            label1.text("사용 가능한 ID 입니다");
		        }
		    },
		    error: function(xhr, status, error) {
		        console.log("에러발생:", error);
		    }
		});

	});
}); /* function 마지막 중괄호 */
</script>
<jsp:include page="header.jsp"></jsp:include>

<form action="${pageContext.request.contextPath}/insert_member" method="post" name="frm" onsubmit="return addCheck()">
	<div id="signUp-box">
		<div id="signUp-header">
			<a href="메인페이지">
				<img class="header-img" src="resources/img/Soomtoon_logo.png"/>
			</a>
		</div>
		<div class="content_box">
			<label for="id" id="label1"><h5>아이디</h5></label>
			<input type="text" name="id" id="id" placeholder="ID를 입력해주세요"/>
			<h5>비밀번호</h5>
			<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력해주세요"/>
			<h5>이름</h5>
			<input type="text" name="name" id="name" placeholder="이름을 입력해주세요"/>
			<h5>닉네임</h5>
			<input type="text" name="alias" id="alias" placeholder="닉네임을 입력해주세요"/>
			<h5>주민번호</h5>
			<input type="text" name="jumin1" id="jumin1" maxlength="6" placeholder="주민번호 앞자리"/>
			-
			<input type="password" name="jumin2" id="jumin2" maxlength="7" placeholder="주민번호 앞자리"/>
			<div id="btn-box">
				<input class="signUp-btn" type="submit" value="가입하기"/>
			</div>
		</div>
	</div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>