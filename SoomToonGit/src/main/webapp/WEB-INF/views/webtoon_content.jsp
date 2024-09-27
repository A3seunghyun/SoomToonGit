<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webtoon-content</title>
<link href="resources/css/webtoon-content.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="resources/css/board_list.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/webtoon_content.js" defer></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="webtoon-content">
		<div class="webtoon-box">
			<div class="webtoon-img">
				<div class="webtoon-background"></div>
				<div class="img-container">
					<img alt="썸네일" src="//page-images.kakaoentcdn.com/download/resource?kid=Cf0LJ/hynaH4y8E5/l5Qk7VWfAsyYkE8yKmRFdk&amp;filename=o1/dims/resize/384">
				</div>
			</div>
		</div>
		
		<div class="webtoon-info">
			<div>
				<div class="webtoon-info-box">
					<span class="webtoon-title">나 혼자만 레벨업</span>
					<span class="webtoon-author">현군,장성락(REDICE STUDIO),추공</span>
					<div class="webtoon-genre">
						<img alt="웹툰" aria-hidden="true" width="16" height="16" decoding="async" data-nimg="1" class="active:opacity-30 mr-2pxr" src="data:image/svg+xml,%3csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cg id='content_home / ic_content_home_comic'%3e %3cpath id='icon' opacity='0.4' fill-rule='evenodd' clip-rule='evenodd' d='M4 2C2.89543 2 2 2.89543 2 4V12C2 13.1046 2.89543 14 4 14H12C13.1046 14 14 13.1046 14 12V4C14 2.89543 13.1046 2 12 2H4ZM5.66667 3H4C3.44772 3 3 3.44772 3 4V7.5H8.66667L5.66667 3ZM6.91667 3L9.91667 7.5H13V4C13 3.44772 12.5523 3 12 3H6.91667ZM13 12V8.5H3V12C3 12.5523 3.44772 13 4 13H12C12.5523 13 13 12.5523 13 12Z' fill='black'/%3e %3c/g%3e %3c/svg%3e" style="color: transparent;">
						<div class="webtoon-genre-item">
							<span>웹툰</span>
							<img alt="리스트 구분자" aria-hidden="true" width="6" height="14" decoding="async" data-nimg="1" class="pointer-events-none inline cursor-default select-none" src="data:image/svg+xml,%3csvg width='6' height='14' viewBox='0 0 6 14' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3ccircle opacity='0.7' cx='3' cy='7' r='1' fill='black'/%3e %3c/svg%3e" style="color: transparent;">
							<span>판타지</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="main-container">
		<div class="search-bar">
			<div class="search-option">
				<label for="search-type" hidden>검색 유형</label>
				<select class="form-control" id="search-type" name="searchType">
					<option>제목</option>
					<option>웹툰명</option>
					<option>작성자</option>
				</select>
			</div>
            <input type="text" placeholder="검색어..." id="search-box">
            <button id="search-btn">🔍</button>
        </div>

        <table>
			<colgroup>
				<col class="col1"><col class="col2"><col class="col3"><col class="col4"><col class="col5">
			</colgroup>
            <thead>
                <tr>
                    <th>웹툰명</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>댓글수</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/webtoonContent">나 혼자만 레벨업</a></td>
                    <td><a href="${pageContext.request.contextPath}/boardDetail">최신화 빨리 내놔!!!!</a></td>
                    <td>장용준</td>
                    <td>2024-09-26</td>
                    <td>777</td>
                    <td>77</td>
                </tr>
            </tbody>
        </table>

		<div class="pagination">
			<div>
				<button class="pagination-btn">Previous</button>
				<button class="pagination-btn">1</button>
				<button class="pagination-btn">Next</button>
            </div>
        	<button class="write-btn" id="write-btn">글쓰기</button>
        </div>
    </div>
    
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>