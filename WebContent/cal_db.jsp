<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.sql.DriverManager" %>
    <%@ page import = "java.sql.Connection"%>
    <%@ page import = "java.sql.Statement"%>
     <%@ page import = "java.sql.PreparedStatement"%>
    <%@ page import = "java.sql.ResultSet" %>
    <%@ page import = "java.sql.SQLException" %>
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
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>일정 추가</title>
</head>
<body>
<h3>일정 추가</h3>
<hr>
<form name = addplan method=post action=cal_db.jsp>
<input type=text name=cyear size=4>년
<input type=text name=cmonth size=2>월
<input type=text name=cday size=2>일
페어 이름:<input type = text name= cname>
기관:<input type=text name=cplace>
<input type=submit value="추가"></form>

<% stmt=conn.createStatement();
if(request.getParameter("babyname")!=null){
String sql="insert into calendar (babyyear,babymonth,babyday,babyname,babyplace) values(";
sql+=request.getParameter("cyear");
sql+=",";
sql+=request.getParameter("cmonth");
sql+=", ";
sql+=request.getParameter("cday");
sql+=", '";
sql+=request.getParameter("cname");
sql+="','";
sql+=request.getParameter("cplace");
sql+=" ')"; 
stmt.executeUpdate(sql);
}
PreparedStatement pstmt = null;
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