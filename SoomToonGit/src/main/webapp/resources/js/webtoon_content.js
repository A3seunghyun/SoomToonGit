window.addEventListener("DOMContentLoaded", function(){
	let writeBtn = document.getElementById("write-btn");
		
	writeBtn.addEventListener("click", function() {
		location.href="writePost";
	});
	
	let thumbnailImg = document.getElementById("webtoonimg-thumbnail").src;
    
    // 웹툰 배경 요소 선택
    let backgroundImg = document.querySelector(".webtoon-background");

    // 배경 이미지 속성을 src 값으로 동적으로 설정
    backgroundImg.style.backgroundImage = `url(${thumbnailImg})`;
});