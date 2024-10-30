window.addEventListener("DOMContentLoaded", function () {
    let stageBtn = document.getElementById("stage-btn");
    let storageBtn = document.getElementById("storage-btn");
    let giftBtn = document.getElementById("gift-btn");

    if (stageBtn) stageBtn.addEventListener("click", preparing);
    if (storageBtn) storageBtn.addEventListener("click", preparing);
    if (giftBtn) giftBtn.addEventListener("click", preparing);

    function preparing() {
        alert("준비중입니다.");
    }

    let userInfoBtn = document.getElementById("user-info-btn");
    let infoMenu = document.getElementById("info-menu");

    if (userInfoBtn) {
        userInfoBtn.addEventListener("click", function () {
            infoMenu.classList.toggle("hideanddisplay");
        });
    }

    let loginBtn = document.getElementById("login-btn");

    if (loginBtn) {
        loginBtn.addEventListener("click", function() {
            location.href = "login"; // 로그인 페이지로 이동하려면 이 줄을 주석 해제하세요.
        });
    }

    let logoutBtn = document.getElementById("logout-btn");

    if (logoutBtn) {
        logoutBtn.addEventListener("click", function() {
            location.href = "logout"; // 로그아웃 처리
        });
    }
});