<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    <jsp:useBean id="event" class="calendar.EventBean" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>event add</title>
</head>
<body>
<h2>�̺�Ʈ �߰�</h2>
ID : <jsp:getProperty property="id" name="event"/><br>
Name : <jsp:getProperty property="name" name="event"/><br>
Date : <jsp:getProperty property="date" name="event"/><br>
Place : <jsp:getProperty property="place" name="event"/><br>
�� ������ �߰���.
</body>
</html>