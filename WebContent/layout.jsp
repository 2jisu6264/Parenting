<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
    <link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
.header{
padding:30px;
text-align: center;
background: white;
}
.h1{
font-size : 50px;
font-family: 'Gloria Hallelujah', cursive; 
}
.leftcolumn{
float: left;
width: 75%;
}
.rightcolumn{
float: left; width:25%; background-color: #f1f1f1;
padding-left: 20px;
}
</style>
</head>
<body>
<div>
<p id="h1"> Baby fair</p>
</div>
<table>
<tr>
<td id="leftcolumn">
<jsp:include page="calendar.jsp"/></td>
<td id="rightcolumn">
<jsp:include page="category.jsp"/></td>
</tr>

</table>

</body>
</html>