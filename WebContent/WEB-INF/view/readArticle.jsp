<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기</title>
<link rel="stylesheet" href="../bootstrap-3.3.2-dist/css/bootstrap.min.css">
</head>
<body>
<table class="table" width="500px" style="table-layout:fixed;">
<tr>
	<th class="info" width="100px">번호</th>
	<td>${articleData.article.number}</td>
</tr>
<tr>
	<th class="info">작성자</th>
	<td>${articleData.article.writer.name}</td>
</tr>
<tr>
	<th class="info">제목</th>
	<td><c:out value='${articleData.article.title}' /></td>
</tr>
<tr>
	<th class="info">내용</th>
	<td style="word-break:break-all;"><u:pre value='${articleData.content}'/></td>
</tr>
</table>
<div class="container">
        <label for="content">댓글</label>
        <form method="get">
            <div>
               <!-- <input type="hidden" name="bno" value="${detail.bno}"/> -->
               <input type="text" name="content" value="${param.content}" placeholder="댓글을 입력하세요...">
				<c:if test="${errors.content}"><script>alert('제목을 입력하세요.'); window.history.go(-1)</script></c:if>
				<input type="submit" value="등록">
              </div>
        </form>
</div>
<div class="container">
<c:if test="">
	<tr>
		<td colspan="4">댓글이 없습니다.</td>
	</tr>
</c:if>
<div class="replyList">
	<c:forEach var="reply" items="${replyPage.content}">
        	<div class="replyArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">
        	<div class="replyInfo">댓글번호 : ${reply.number}  작성자 : ${reply.writer.name}
			<a href=""> 수정 </a>
            <a href=""> 삭제 </a> </div>
            <div class="replyContent"> <p>${reply.content}</p></div>
            </div>
	</c:forEach>
</div>
</div>
<table>
<tr>
	<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<a class="btn btn-default pull-right" href="list.do?pageNo=${pageNo}">목록</a>
		<c:if test="${authUser.id == articleData.article.writer.id}">
		<a class="btn btn-default pull-right" href="modify.do?no=${articleData.article.number}">수정</a>
		<a class="btn btn-default pull-right" href="delete.do?no=${articleData.article.number}"
		onclick="if(!confirm('게시글을 삭제하시겠습니까?')) return false;">삭제</a>
		</c:if>
	</td>
</tr>
</table>
<script src="../bootstrap-3.3.2-dist/js/bootstrap.js">
</script>
</body>
</html>