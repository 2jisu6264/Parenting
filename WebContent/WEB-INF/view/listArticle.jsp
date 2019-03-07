<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="../bootstrap-3.3.2-dist/js/bootstrap.js"></script>
<title>게시글 목록</title>
</head>
<body>

<table border="1">
   <tr>
      <td colspan="4"><a href="write.do">[게시글쓰기]</a></td>
   </tr>
   <tr>
      <td>번호</td>
      <td>제목</td>
      <td>작성자</td>
      <td>조회수</td>
   </tr>
<c:if test="${articlePage.hasNoArticles()}">
   <tr>
      <td colspan="4">게시글이 없습니다.</td>
   </tr>
</c:if>
<c:forEach var="article" items="${articlePage.content}">
   <tr>
      <td>${article.number}</td>
      <td>
      <a href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}">
      <c:out value="${article.title}"/>
      </a>
      </td>
      <td>${article.writer.name}</td>
      <td>${article.readCount}</td>
   </tr>
</c:forEach>
<c:if test="${articlePage.hasArticles()}">
<<<<<<< HEAD
	<div class="text-center">
		<ul class="pagination">
		<c:choose>
		<c:when test="${search==''}"> <!-- 전체 리스트에서의 페이지네이션 -->
			<c:if test="${articlePage.startPage > 5}">
			<li><a href="list.do?pageNo=${articlePage.startPage - 5}">이전</a></li>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${articlePage.startPage}" 
					   end="${articlePage.endPage}">
			<li><a href="list.do?pageNo=${pNo}">${pNo}</a></li>
			</c:forEach>
			<c:if test="${articlePage.endPage < articlePage.totalPages}">
			<li><a href="list.do?pageNo=${articlePage.startPage + 5}">다음</a></li>
			</c:if>
		</c:when>
		<c:otherwise> <!-- 검색 결과에서의 페이지네이션 -->
			<li>${option}에 '${search}'가 포함된 게시글의 검색결과입니다.<br></li>
			<c:if test="${articlePage.startPage > 5}">
			<li><a href="list.do?search=${search}&option=${option}&pageNo=${articlePage.startPage - 5}">이전</a></li>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${articlePage.startPage}" 
					   end="${articlePage.endPage}">
			<li><a href="list.do?search=${search}&option=${option}&pageNo=${pNo}">${pNo}</a></li>
			</c:forEach>
			<c:if test="${articlePage.endPage < articlePage.totalPages}">
			<li><a href="list.do?search=${search}&option=${option}&pageNo=${articlePage.startPage + 5}">다음</a></li>
			</c:if>
		</c:otherwise>
		</c:choose>
		</ul>
	</div>

   <tr>
      <td colspan="4">
         <c:if test="${articlePage.startPage > 5}">
         <a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
         </c:if>
         <c:forEach var="pNo" 
                  begin="${articlePage.startPage}" 
                  end="${articlePage.endPage}">
         <a href="list.do?pageNo=${pNo}">[${pNo}]</a>
         </c:forEach>
         <c:if test="${articlePage.endPage < articlePage.totalPages}">
         <a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
         </c:if>
      </td>
   </tr>
</c:if>
</table>

<div>
	
		<form method="get" action="list.do">
				<select name="option">
					<option>제목</option>
					<option>작성자</option>
					<option>내용</option>
				</select>
  				<input type="text" id="search" name="search" size="15" placeholder="검색어를 입력하세요">
  						<!-- <input type="hidden" name="mode"value="board_search">  -->
				<input type="submit" value="검색">
		</form>
</div>
<a class="btn btn-default pull-right" href="write.do">게시글쓰기</a>


</body>
</html>