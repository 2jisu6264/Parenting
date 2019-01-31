<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 예제</title>
<link rel="stylesheet" href="bootstrap-3.3.2-dist/css/bootstrap.min.css">
</head>
<body>
<%-- 
<c:if test="${! empty authUser}">
	${authUser.name}님, 안녕하세요.
	<a href="logout.do">[로그아웃하기]</a>
	<a href="changePwd.do">[암호변경하기]</a>
</c:if>
<c:if test="${empty authUser}">
	<a href="join.do">[회원가입하기]</a>
	<a href="login.do">[로그인하기]</a>
</c:if>
--%>
<!-- c:if 태그를 사용하는 것이 나쁘진 않지만,
코드 의미가 잘 드러날 수 있도록 다음과 같이 로그인 여부를 검사하는 커스텀 태그를 구현하면 좋을 것이다. -->
<u:isLogin>
	${authUser.name}님, 안녕하세요.<br>
	<a class="btn btn-default" href="logout.do">로그아웃하기</a><br>
	<a class="btn btn-default" href="changePwd.do">암호변경하기</a>
</u:isLogin>
<u:notLogin>
	로그인 해주세요.<br>
	<a class="btn btn-default" href="login.do">로그인하기</a><br>
	<a class="btn btn-default" href="join.do">회원가입하기</a>
</u:notLogin>
<script src="bootstrap-3.3.2-dist/js/bootstrap.js"></script>
</body>
</html>