<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc-kr"); %>
    <jsp:useBean id="SimpleBean" class="javaBean.SimpleBean" >
    <jsp:setProperty name="SimpleBean" property="year"  /> 
    <jsp:setProperty name="SimpleBean" property="month"  />
    <jsp:setProperty name="SimpleBean" property="day"  />
<jsp:setProperty name="SimpleBean" property="name"  />
<jsp:setProperty name="SimpleBean" property="place"  />
<jsp:setProperty name="SimpleBean" property="url" />
</jsp:useBean>
<%@ page import="javaBean.MemberService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% new MemberService().iventInsert(SimpleBean); 
%>
<table width = "300px" height = "20px">
    <tr>
    <td><jsp:getProperty name="SimpleBean" property="year" />년</td>
    <td><jsp:getProperty name="SimpleBean" property="month" />월</td>
    <td><jsp:getProperty name="SimpleBean" property="day" />일</td> </tr>
   <tr><td>이벤트 이름</td>
    <td><jsp:getProperty name="SimpleBean" property="name" /></td> </tr>
   <tr> <td>이벤트 장소</td>
    <td><jsp:getProperty name="SimpleBean" property="place" /></td></tr>
   <tr><td>페이지 주소</td>
    <td><jsp:getProperty name="SimpleBean" property="url" /></td> </tr>
</table>
</body>
</html>