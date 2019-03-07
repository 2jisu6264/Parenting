<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
a{
text-decoration:none; 
}
.header{
padding:0px;
text-align: center;
background: white;
}
.leftcolumn{
float: left;
width: 80%;
}
.rightcolumn{
float: left; width:20%; background-color: #f1f1f1;
 align:top;
}
</style>
</head>
<body>
<div>
<a href="calendar.jsp" target="main" style="font-size:50px; font-family: 'Open Sans', sans-serif; font-color:#D5D5D5; padding-left:500px;"> Baby fair</a>
</div>
<table>
<tr>
<td id="leftcolumn">
<iframe  width="1000" height="700" src="calendar.jsp" name="main" frameborder="0" scrolling="auto"></iframe>
<td id="rightcolumn">
<table style="border-collapse:separate; border-spacing:20px; align:top;">
<tr><td><jsp:include page="/WEB-INF/view/loginForm.jsp"/></td></tr>
<tr><td><jsp:include page="category.jsp"/></td></tr>
</table>
</td>
</tr>

</table>

</body>
</html>