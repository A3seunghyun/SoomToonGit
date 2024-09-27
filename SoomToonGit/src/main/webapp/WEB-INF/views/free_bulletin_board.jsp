<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/board_list.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/free_bulletin_board.js" defer></script>
	
	<form action="freebulletinboard" method="get">
		<div class="main-container">
		<h2>자유게시판</h2>
		<hr>
			<div class="search-bar">
				<div class="search-option">
					<label for="search-type" hidden>검색 유형</label>
					<select class="form-control" id="search-type" name="searchType">
						<option>제목</option>
						<option>웹툰명</option>
						<option>작성자</option>
					</select>
				</div>
	            <input type="text" placeholder="검색어..." id="search-box" name="searchTerm">
	            <button type="submit" id="search-btn">🔍</button>
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
					<button type="button" class="pagination-btn">Previous</button>
					<button type="button" class="pagination-btn">1</button>
					<button type="button" class="pagination-btn">Next</button>
	            </div>
	        	<button type="button" class="write-btn" id="write-btn">글쓰기</button>
	        </div>
	    </div>
    </form>
    
    <jsp:include page="footer.jsp"></jsp:include>
    
</body>
</html>