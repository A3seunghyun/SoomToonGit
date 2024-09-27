window.onload = function () {
	let stageBtn = document.getElementById("stage-btn");
	let storageBtn = document.getElementById("storage-btn");
	let giftBtn = document.getElementById("gift-btn");
	
	
	stageBtn.addEventListener("click", preparing);
	storageBtn.addEventListener("click", preparing);
	giftBtn.addEventListener("click", preparing);
	
	
	function preparing() {
		alert("준비중입니다.");
	}
	
	let userInfoBtn = document.getElementById("user-info-btn");
	let infoMenu = document.getElementById("info-menu");
	
	userInfoBtn.addEventListener("click", function () {
		infoMenu.classList.toggle("hideanddisplay");
	})
	
	let logoinBtn = document.getElementById("logoin-btn");
	
	logoinBtn.addEventListener("click", function() {
		location.href = "login";
	})
}