<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/board_detail.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board_detail.js" defer></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<h1>${boardDetail[0].title }</h1>
		<div class="post-info">
			<span class="author">작성자: ${boardDetail[0].userName }</span>
			<span class="date">작성일: ${boardDetail[0].postDate }</span>
			<span class="views">조회수: ${boardDetail[0].postView } (구현중)</span>
			<span class="comments">댓글수: 구현중</span>
		</div>
		<hr>
		<div class="post-content">
			<p>${boardDetail[0].postContent }</p>
		</div>
		<hr>
		<button class="back-btn" id="back-btn">목록으로</button>
		
		<c:if test="${boardDetail[0].userId == userId}">
    		<button class="back-btn" id="delete-btn" style="float: right; margin-left: 14px;">삭제</button>
    		<form action="${pageContext.request.contextPath}/editPage" method="post" style="display: inline;">
    			<input type="hidden" id="postIdx" name="postIdx" value="${boardDetail[0].postIdx}">
				<input type="hidden" id="postTitle" name="postTitle" value="${boardDetail[0].title }">
				<input type="hidden" id="postContent" name="postContent" value="${boardDetail[0].postContent }">
    			<button type="submit" class="back-btn" id="edit-btn" style="float: right; margin-left: 14px;">수정</button>
    		</form>
		</c:if>
	</div>
	
	<!-- Modal -->
    <div id="deleteModal" class="modal">
        <div class="modal-content">
            <span class="close" id="closeModal">&times;</span><br/>
            <h2>삭제 확인</h2>
            <p>아래의 4자리 숫자를 입력하세요</p>
            <div id="randomNumber" class="random-number"></div>
            <input type="text" id="inputNumber" placeholder="4자리 숫자 입력">
            <hr/>
            <button id="confirmDelete" class="confirmDelete">확인</button>
        </div>
    </div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		let contextPath = "${pageContext.request.contextPath}";
		let postIdx = "${boardDetail[0].postIdx}";
	</script>
</body>
</html>