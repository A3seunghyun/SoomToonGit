window.addEventListener("DOMContentLoaded", function() {
    let webtoonSearchBtn = document.getElementById("webtoon_name");
    let modal = document.getElementById("webtoonModal");
    let closeModal = document.querySelector(".modal .close");

    webtoonSearchBtn.addEventListener("click", function() {
        modal.style.display = "flex";
    });

    closeModal.addEventListener("click", function() {
        modal.style.display = "none";
    });

    let searchBtn = document.getElementById("search-btn");

    searchBtn.addEventListener("click", function() {
        let webtoonName = document.getElementById("webtoonName").value;
        let webtoonResults = document.getElementById("webtoonSelect");
        let resultCount = document.getElementById("resultCount");

        $.ajax({
            url: contextPath + '/ajax/WebtoonSearch',
            data: JSON.stringify({"webtoonName": webtoonName}),
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function(result) {
                if (result.length > 0) {
                    console.log("검색성공:", result);
                    webtoonResults.innerHTML = "";

                    result.forEach(function(webtoon) {
                        webtoonResults.innerHTML += `<option value="${webtoon.webtoonIdx}">${webtoon.webtoonName}</option>`;
                    });
                    
                    // 확인 버튼이 이미 존재하는지 확인
                    if (!document.getElementById("check-btn")) {
                        // 확인 버튼을 표시
                        let checkBtn = document.createElement("button");
                        checkBtn.className = "search-btn";
                        checkBtn.id = "check-btn";
                        checkBtn.style.cssText = "float: right; width: 100%;";
                        checkBtn.innerText = "확인";
                        document.getElementById("results").appendChild(checkBtn);
                    }
                } else {
                    webtoonResults.innerHTML = `<option value="">웹툰을 선택하세요</option>`;
                }

                resultCount.innerHTML = `총 ${result.length}건의 결과가 있습니다.`;
            },
            error: function(xhr, status, error) {
                console.log("에러발생:", error);
            }
        });
    });

    // 이벤트 위임을 사용하여 확인 버튼 클릭 이벤트 처리
    document.getElementById("check-btn").addEventListener("click", function(event) {
            let selectedOption = document.getElementById("webtoonSelect").options[document.getElementById("webtoonSelect").selectedIndex]; // 선택한 option
            let selectedWebtoonValue = selectedOption.value; // 선택한 option의 value
            let selectedWebtoonText = selectedOption.text; // 선택한 option의 텍스트
            
            document.getElementById("webtoon_name").value = selectedWebtoonText;
            document.getElementById("webtoon_name_value").value = selectedWebtoonValue;
            
            modal.style.display = "none";
    });
    
    document.querySelector('.write_form').addEventListener('submit', function(event) {
	    // 입력 필드 값 가져오기
	    let webtoonName = document.getElementById('webtoon_name').value.trim();
	    let title = document.getElementById('title').value.trim();
	    let content = document.getElementById('content').value.trim();
	    
	    let errorMessage = ''; // 오류 메시지를 저장할 변수
	
	    // 웹툰명 검사
	    if (!webtoonName) {
	        errorMessage += "웹툰명을 입력해주세요.\n";
	    }
	
	    // 제목 검사
	    if (!title) {
	        errorMessage += "제목을 입력해주세요.\n";
	    }
	
	    // 내용 검사
	    if (!content) {
	        errorMessage += "내용을 입력해주세요.\n";
	    }
	
	    // 오류가 있을 경우
	    if (errorMessage) {
	        event.preventDefault(); // 폼 제출 방지
	        alert(errorMessage); // 오류 메시지 표시
	    }
	});
});