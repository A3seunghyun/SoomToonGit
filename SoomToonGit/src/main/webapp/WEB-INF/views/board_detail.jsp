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
			<span class="views">조회수: ${boardDetail[0].postView }</span>
			<span class="comments">댓글수: ${boardDetail[0].commentCount + boardDetail[0].childCommentCount }</span>
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
	<!-- 댓글 섹션 시작 -->
    <div class="comments-section">
        <h3>댓글</h3>

        <!-- 댓글 입력 창 -->
        <c:if test="${not empty sessionScope.userId}">
	        <div class="comment-form">
	        	<form action="${pageContext.request.contextPath}/writeComment" method="post" style="display: flex;">
		        	<input type="hidden" id="postIdx" name="postIdx" value="${boardDetail[0].postIdx}">
		        	<input type="hidden" id="userIdx" name="userIdx" value="${userInfo.user_idx}">
		            <input type="text" id="commentInput" name="content" placeholder="댓글을 입력하세요." value="">
		            <button type="submit" class="registration-btn" id="registration-btn" style="width: 60px;">등록</button>
	            </form>
	        </div>
        </c:if>

        <!-- 댓글 목록 -->
        <div id="commentsList">
        	<c:forEach var="comments" items="${boardComments}">
	            <div class="comment">
	                <span class="author">${comments.userName }</span>
	                <span class="date">${comments.commentDate}</span>
	                <p class="comment-content">${comments.content}</p>
	                <button class="reply-btn" onclick="showReplyForm(this)">답글</button>
	
	                <!-- 댓글 답변 목록 -->
	                <div class="replies" style="display: none;">
	                	<c:forEach var="childComments" items="${childComments }">
	                		<c:if test="${comments.commentIdx == childComments.commentIdx}">
			                    <div class="reply">
			                        <span class="author">${childComments.userName }</span>
			                        <span class="date">${childComments.childCommentDate }</span>
			                        <p class="reply-content">${childComments.childContent}</p>
			                    </div>
			                    <hr/>
		                    </c:if>
	                    </c:forEach>
	                    
	                    <!-- 답변 입력 창 (기본 숨김) -->
	                    <c:if test="${not empty sessionScope.userId}">
		                    <div class="reply-form" style="flex">
		                    	<form action="${pageContext.request.contextPath}/writeChildComment" method="post" style="display: flex;">
		                    		<input type="hidden" id="postIdx" name="postIdx" value="${boardDetail[0].postIdx}">
		        					<input type="hidden" id="commentIdx" name="commentIdx" value="${comments.commentIdx}">
		        					<input type="hidden" id="userIdx" name="userIdx" value="${userInfo.user_idx}">
			                        <input type="text" id="childContent" name="childContent" value="" placeholder="답변을 입력하세요.">
			                        <button type="submit" class="registration-btn" onclick="addReply(this)">등록</button>
		                        </form>
		                    </div>
	                    </c:if>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
    <!-- 댓글 섹션 끝 -->
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