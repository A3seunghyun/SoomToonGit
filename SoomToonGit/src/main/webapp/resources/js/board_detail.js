window.addEventListener("DOMContentLoaded", function(){
	let backBtn = document.getElementById("back-btn");
			
	backBtn.addEventListener("click", function() {
		location.href = "freeBulletinBoard";
	})
	
	let deleteBtn = document.getElementById("delete-btn");
    let modal = document.getElementById("deleteModal");
    let closeModal = document.getElementById("closeModal");
    let randomNumberDiv = document.getElementById("randomNumber");
    let inputNumber = document.getElementById("inputNumber");
    let confirmDelete = document.getElementById("confirmDelete");

    // 4자리 랜덤 숫자 생성
    function generateRandomNumber() {
        return Math.floor(1000 + Math.random() * 9000).toString();
    }

    // 삭제 버튼 클릭 시 모달 열기
    deleteBtn.onclick = function() {
        let randomNumber = generateRandomNumber();
        randomNumberDiv.textContent = randomNumber; // 랜덤 숫자 표시
        modal.style.display = "block";
    }

    // 모달 닫기
    closeModal.onclick = function() {
    	inputNumber.value = ''; // 입력 필드 초기화
        modal.style.display = "none";
    }

    // 확인 버튼 클릭 시
    confirmDelete.onclick = function() {
        let enteredNumber = inputNumber.value;
        let displayedNumber = randomNumberDiv.textContent;

        // 입력한 숫자가 랜덤 숫자와 같은지 확인
        if (enteredNumber === displayedNumber) {
            location.href = contextPath + "/deletePost?postIdx=" + postIdx;
        } else {
            alert("입력한 숫자가 일치하지 않습니다. 다시 시도하세요.");
            inputNumber.value = ''; // 입력 필드 초기화
        }
    }
    
    let editBtn = document.getElementById("edit-btn");
    
    editBtn.addEventListener("click", function(){
    	
    });
    
});

function showReplyForm(button) {
    let replies = button.parentElement.querySelector('.replies');
    
    // replies이 존재하는 경우 표시/숨김 전환
    if (replies) {
        replies.style.display = replies.style.display === 'none' ? 'block' : 'none';
    }
};

document.getElementById("registration-btn").onclick = function(event) {
    // 댓글 입력 필드의 값을 가져옵니다.
    let commentInput = document.getElementById("commentInput");
    
    // 댓글 내용이 비어 있는지 확인합니다.
    if (commentInput.value.trim() === "") {
        alert("댓글을 입력해주세요."); // 경고 메시지 표시
        event.preventDefault(); // 폼 제출을 막습니다.
        commentInput.focus(); // 입력 필드에 포커스를 맞춥니다.
    }
};