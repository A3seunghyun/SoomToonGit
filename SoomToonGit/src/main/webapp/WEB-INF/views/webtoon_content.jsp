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
						<div class="rating-avg">
							<img alt="별점" aria-hidden="true" width="16" height="16" decoding="async" data-nimg="1" class="pointer-events-none mr-2pxr" src="data:image/svg+xml,%3csvg width='16' height='16' viewBox='0 0 16 16' fill='none' xmlns='http://www.w3.org/2000/svg'%3e %3cg id='content_home / ic_content_home_star'%3e %3cpath id='icon' opacity='0.4' fill-rule='evenodd' clip-rule='evenodd' d='M8.0034 2.50039C8.00293 2.50017 8.0023 2.5 8.00155 2.5C8.0008 2.5 8.00017 2.50017 7.99969 2.5004L6.49184 5.6765L3.01065 6.13292L5.56462 8.5308L4.9211 11.949L7.95434 10.3013L11.0248 11.9986C11.0246 11.9987 11.0251 11.9985 11.0248 11.9986L11.0602 11.9873L11.0788 11.9842L10.4394 8.5308L12.9827 6.13293L9.50058 5.67639L8.0034 2.50039ZM7.48603 1.64238C7.64191 1.54913 7.8201 1.5 8.00155 1.5C8.183 1.5 8.3612 1.54913 8.51708 1.64238C8.67289 1.7356 8.80061 1.86942 8.88635 2.02971L8.89233 2.04088L10.1722 4.75588L13.1232 5.14279C13.2521 5.15798 13.3766 5.19824 13.4898 5.26117C13.6047 5.32501 13.7058 5.41105 13.7873 5.51443C13.8686 5.61761 13.9288 5.73609 13.964 5.86313C13.9992 5.99014 14.0087 6.12275 13.992 6.25318L13.9911 6.26071L13.9899 6.26821C13.9544 6.49146 13.8452 6.69625 13.6798 6.85009L11.5219 8.88458L12.0635 11.8099C12.0886 11.9376 12.0882 12.0692 12.0618 12.1971C12.0352 12.3263 11.9828 12.4488 11.9078 12.5572C11.8328 12.6657 11.7367 12.7579 11.6254 12.8284C11.5244 12.8923 11.4127 12.9373 11.2959 12.9612C11.1008 13.0162 10.8936 13.0127 10.7 12.9508L10.6534 12.9359L7.95015 11.4416L5.32297 12.8688C5.09267 12.989 4.82473 13.0151 4.57562 12.942C4.32652 12.869 4.11502 12.7022 3.98629 12.4762L3.96067 12.4312L3.94481 12.3819C3.88251 12.1884 3.87899 11.981 3.93424 11.7859L4.48045 8.88457L2.31282 6.84942C2.17564 6.72059 2.07781 6.55532 2.03104 6.37289C1.98428 6.1905 1.99044 5.99855 2.04892 5.81947C2.1074 5.64037 2.2157 5.48186 2.3608 5.36221C2.50561 5.2428 2.68127 5.16691 2.86731 5.14316L5.82198 4.75577L7.11116 2.04028L7.11682 2.02971C7.20248 1.86957 7.33007 1.73569 7.48603 1.64238Z' fill='black'/%3e %3c/g%3e %3c/svg%3e" style="color: transparent;">
							<span>9.9</span>
						</div>
					</div>
				</div>
			</div>
			
			<form action="webtoonRating" method="post">
				<div class="star-rating">
				    <input type="radio" id="star5" name="rating" value="5"><label for="star5" title="5 stars">★</label>
				    <input type="radio" id="star4" name="rating" value="4"><label for="star4" title="4 stars">★</label>
				    <input type="radio" id="star3" name="rating" value="3"><label for="star3" title="3 stars">★</label>
				    <input type="radio" id="star2" name="rating" value="2"><label for="star2" title="2 stars">★</label>
				    <input type="radio" id="star1" name="rating" value="1"><label for="star1" title="1 star">★</label>
				</div>
				<button class="rating-submit-btn" onclick="submitRating()">평점 제출</button>
			</form>
			
		</div>
	</div>
	
	<div class="main-container">
		<form action="freeBulletinBoard" method="get">
			<div class="search-bar">
				<div class="search-option">
					<label for="search-type" hidden>검색 유형</label>
					<select class="form-control" id="search-type" name="searchType">
						<option value="title">제목</option>
						<option value="webtoonName">웹툰명</option>
						<option value="userName">작성자</option>
					</select>
				</div>
	            <input type="text" placeholder="검색어..." id="search-box" name="searchTerm">
	            <button type="submit" id="search-btn">🔍</button>
	        </div>
		</form>
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
                    <td style="text-align: center;">${board.commentCount + board.childCommentCount }</td>
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