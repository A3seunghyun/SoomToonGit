window.addEventListener("DOMContentLoaded", function(){
	let loginBtn = document.getElementById("login-btn");

	loginBtn.addEventListener("click", function() {
		let username = document.getElementById("username").value;
		let password = document.getElementById("password").value;
               
		if (username === "" || password === "") {
			alert("아이디와 비밀번호를 입력하세요.");
		}
	})
	
	let joinMember = document.getElementById("join-member");
	
	joinMember.addEventListener("click", function(){
		location.href = "sign_up";
	})

});