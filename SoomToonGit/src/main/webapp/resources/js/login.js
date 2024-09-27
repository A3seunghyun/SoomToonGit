window.addEventListener("DOMContentLoaded", function(){
	let loginBtn = document.getElementById("login-btn");

	loginBtn.addEventListener("click", function() {
		let username = document.getElementById("username").value;
		let password = document.getElementById("password").value;
               
		if (username === "" || password === "") {
			alert("아이디와 비밀번호를 입력하세요.");
		} else {
			alert("로그인 시도 중...");
		}
	});
});