<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 130px;
    background-color: #f1f1f1;
}
li a {
    display: block;
    color: #000;
    padding: 8px 8px;
    text-decoration: none;	
	font-family: 'Sunflower', sans-serif;
    text-align:center;
}
li a.active {
    background-color: #FFB2D9;
    color: white;
}
li a:hover:not(.active) {
    background-color: #FFB2D9;
    color: white;
}
</style>
</head>
<body>
	<ul>
	<li><a class="active" href="calendar.jsp" target="main">�޴�(�޷�)</a></li>
	<li><a href="cal_db.jsp" target="main">�ϱ� �Խ���</a></li>
	<li><a href="cal_db.jsp" target="main">��������</a></li>
	<li><a href="cal_db.jsp" target="main">���� �Խ���</a></li>
	</ul>
</body>
</html>