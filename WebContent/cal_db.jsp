<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.sql.DriverManager" %>
    <%@ page import = "java.sql.Connection"%>
    <%@ page import = "java.sql.Statement"%>
    <%@ page import = "java.sql.PreparedStatement"%>
    <%@ page import = "java.sql.ResultSet" %>
    <%@ page import = "java.sql.SQLException" %>
    <!DOCTYPE html>
<%

Connection conn = null;
Statement stmt = null;
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
<html>
<head>
<meta charset="EUC-KR">
<title>일정 추가</title>
</head>
<body>
<h3>일정 추가</h3>
<hr>
<form action= "cal_list.jsp"  method=post>
<input type=text name=year size=4>년
<input type=text name=month size=2>월
<input type=text name=day size=2>일<br>
페어 이름:<input type=text name=name><br>
기관:<input type=text name=place><br>
페이지 주소:<input type=text name=url>
<input type=submit value="추가"></form>
<h2>이벤트 목록</h2>
<table border="1">
<tr> <th>Index</th>
<th>Name</th>
<th>Date</th>
<th>Place</th>
</tr>
</table>
<% PreparedStatement pstmt = null;
String sql = "SELECT babyname, babyplace FROM calendar";
pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
int i=1;
 while(rs.next()){
 out.print(i + rs.getString("babyname"));
 out.print(i + rs.getString("babyplace"));
	i++;}

rs.close();
%>
</body>
</html>