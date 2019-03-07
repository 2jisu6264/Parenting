<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.sql.DriverManager" %>
    <%@ page import = "java.sql.Connection"%>
    <%@ page import = "java.sql.PreparedStatement"%>
    <%@ page import = "java.sql.ResultSet" %>
    <%@ page import = "java.sql.SQLException" %>
<%
Connection conn = null;
PreparedStatement pstmt=  null;
String jdbcDriver = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
try{
    Class.forName("com.mysql.cj.jdbc.Driver");
 
    String dbUser = "root";
    String dbPass = "rootpw";
 conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
 System.out.println("Driver found! Connection Good!");
 }catch(SQLException se)
 {se.printStackTrace();
 }
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.min.css"></link>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.say{width:80px; height:30px; background-color:#FFB2D9; font-size:15px; font-family:'Noto Serif KR', serif; text-align:center;}
.input{width:150px; height:30px; font-size:15px; font-family:'Noto Serif KR', serif;
padding-left:3px; padding-top:2px;}
</style>
</head>
<body>
<% 	
request.setCharacterEncoding("UTF-8");
String cname = request.getParameter("cname");	
String cyear = request.getParameter("cyear");
String cmonth = request.getParameter("cmonth");
String cday = request.getParameter("cday");
String curl = request.getParameter("curl");
String cplace = request.getParameter("cplace");
%>
<h2 style="font-family: 'Gloria Hallelujah', cursive; color:#FFB2D9;">baby fair information</h2>
<table>
<tr><th class="say">년</th>
<th class="input"><%out.println(cyear);%></th></tr>
<tr><th class="say">월</th>
<th class="input"><%out.println(cmonth);%></th></tr>
<tr><th class="say">일</th>
<th class="input"><%out.println(cday);%></th></tr>
<tr><th class="say">이름</th>
<th class="input"><%out.println(cname);%></th></tr>
<tr><th class="say">장소</th>
<th class="input"><%out.println(cplace);%></th></tr>
<tr><th class="say">페이지</th>
<th class="input"><a href="curl">바로 가기</a></th></tr>
</table>
<br>
<input type="button" class="btn btn-light" value="돌아가기" onClick="location.href='calendar.jsp'">
</body>
</html>