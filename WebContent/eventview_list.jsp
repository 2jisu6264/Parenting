<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "calendar.EventBean"%>
    <jsp:useBean id="eventlist" class = "java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>event list</title>
</head>
<body>
<h2>이벤트 목록</h2>
<table border="1">
<tr> <th>Index</th>
<th>Name</th>
<th>Date</th>
<th>Place</th>
</tr>
<% for(int i=0; i< eventlist.size() ; i++){
	EventBean event = (EventBean)eventlist.get(i);%>
	<tr>
	<td><%=event.getId() %></td>
	<td><a href="EventContrl?action=view&id = <%=event.getId()%>">
	<%=event.getName()%></a>
	</td>
	<td><%=event.getDate() %></td>
	<td><%=event.getPlace() %></td>
	</tr>
	<% } %>
<p></p>
</table>
<form action="/webservice/EventControl" method="post">
ID<input type ="text" name="id" size=5>
Name<input type ="text" name="name" size=15>
Date<input type="text" name="date" size=19>
Place<input type="text" name="place" size=40>
<input type = "hidden" name="action" value ="add">
<input type="submit" value ="이벤트 추가">
 </form>
</body>
</html>