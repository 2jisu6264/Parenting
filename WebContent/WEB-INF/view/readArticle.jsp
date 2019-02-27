<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@import ="article.service.ArticleData" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기</title>
<link rel="stylesheet" href="../bootstrap-3.3.2-dist/css/bootstrap.min.css">
</head>
<body>
<table border="1" width="100%">
<tr>
	<td>번호</td>
	<td>${articleData.article.number}</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${articleData.article.writer.name}</td>
</tr>
<tr>
	<td>제목</td>
	<td><c:out value='${articleData.article.title}' /></td>
</tr>
<tr>
	<td>내용</td>
	<td><u:pre value='${articleData.content}'/></td>
</tr>
<tr> 
	<td>첨부파일</td>
	<a href = "fileDownload.jsp?file=${articleData.file}">다운로드</a>
</tr>
<tr>
	<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<a href="list.do?pageNo=${pageNo}">[목록]</a>
		<c:if test="${authUser.id == articleData.article.writer.id}">
		<a class="btn btn-default pull-right" href="modify.do?no=${articleData.article.number}">수정</a>
		<a class="btn btn-default pull-right" href="delete.do?no=${articleData.article.number}">삭제</a>
		</c:if>
	</td>
</tr>
</table>

<script src="../bootstrap-3.3.2-dist/js/bootstrap.js"></script>
</body>
</html>