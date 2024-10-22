<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<img id="webtoonimg-thumbnail" alt="썸네일" src="${webtoonDetail[0].webtoonImg }">
				</div>
			</div>
		</div>
		
		<div class="webtoon-info">
			<div>
				<div class="webtoon-info-box">
					<span class="webtoon-title">${webtoonDetail[0].webtoonName }</span>
					<span class="webtoon-author">${webtoonDetail[0].webtoonAuthor }</span>
					<div class="webtoon-genre">
						<img alt="웹툰" aria-hidden="true" width="16" height="16" decoding="async" data-nimg="1" class="active:opacity-30 mr-2pxr" src="data:image/svg+xml,%3csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cg id='content_home / ic_content_home_comic'%3e %3cpath id='icon' opacity='0.4' fill-rule='evenodd' clip-rule='evenodd' d='M4 2C2.89543 2 2 2.89543 2 4V12C2 13.1046 2.89543 14 4 14H12C13.1046 14 14 13.1046 14 12V4C14 2.89543 13.1046 2 12 2H4ZM5.66667 3H4C3.44772 3 3 3.44772 3 4V7.5H8.66667L5.66667 3ZM6.91667 3L9.91667 7.5H13V4C13 3.44772 12.5523 3 12 3H6.91667ZM13 12V8.5H3V12C3 12.5523 3.44772 13 4 13H12C12.5523 13 13 12.5523 13 12Z' fill='black'/%3e %3c/g%3e %3c/svg%3e" style="color: transparent;">
						<div class="webtoon-genre-item">
							<span>${webtoonDetail[0].webtoonGenre }</span>
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
           		<c:forEach var="board" items="${webtoonBoardList }">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/webtoonContent?webtoonIdx=${board.webtoonIdx }">${board.webtoonName}</a></td>
                    <td><a href="${pageContext.request.contextPath}/boardDetail?postIdx=${board.postIdx }">${board.title }</a></td>
                    <td>${board.userName}</td>
                    <td>${board.postDate}</td>
                    <td style="text-align: center;">${board.postView}</td>
                    <td>구현중</td>
                </tr>
                </c:forEach>
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