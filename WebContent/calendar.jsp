<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="calendar.EventBean"%>
  <jsp:useBean id="eventlist" class = "java.util.ArrayList" scope="request"/>
 <%@ page import = "java.util.Calendar" %> 
 <%@ page import="java.util.GregorianCalendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR" rel="stylesheet"></link>
<link rel="stylesheet" href="./css/bootstrap.min.css"></link>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>Calendar</title>
<style type="text/css">
p{font-size:25px; text-align:center; font-family: 'Noto Serif KR', serif;}
#sun{color: #F15F5F;text-align :center;
font-family: 'Noto Serif KR', serif;}
#sat{color: #6799FF;text-align :center;
font-family: 'Noto Serif KR', serif;}
#other{color: #747474;text-align :center;
font-family: 'Noto Serif KR', serif;} //id .는 class 아래는 박혀있는거
pp{text-align: left; vertical-align: top;
  padding-left: 3px; padding-top: 2px}
</style>
</head>

<body>
<% 
Calendar cal = Calendar.getInstance();
int nYear = cal.get(Calendar.YEAR);
int nMonth = cal.get(Calendar.MONTH)+1;
int nDay = cal.get(Calendar.DAY_OF_MONTH);
%>
<p><%=nYear%></p>
<form name="form1" method="post">
<p>
<button type="button" class="btn btn-link">이전</button>
<%=nMonth%>월
<button type="button" class="btn btn-link">다음</button></p>
</form>

<divid>
<table align="center"; border="1px #BDBDBD">
<thread>
<tr>
<th id="sun">일</th>
<th id="other">월</th>
<th id="other">화</th>
<th id="other">수</th>
<th id="other">목</th>
<th id="other">금</th>
<th id="sat">토</th>
</tr>
<%		
for(int tempDay = 1;;tempDay++){
cal.set(Calendar.DAY_OF_MONTH, tempDay);
if(tempDay != cal.get(Calendar.DAY_OF_MONTH)){
break;}
switch(tempDay)	{
case 1: int week = cal.get(Calendar.DAY_OF_WEEK);
for(int blank=1; blank< week; blank++){
%>
<td id="other"></td>
<%
}}
%>
<pp><th  width= 120px; height= 50px;><%=tempDay %></pp>
<%
switch(cal.get(Calendar.DAY_OF_WEEK)){
case Calendar.SATURDAY:
%>
<tr></tr>
<%}} %>
</table>
</divid>
</body>
</html>