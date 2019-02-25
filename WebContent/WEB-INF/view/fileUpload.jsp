<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.File"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> <!-- 동일한 파일명일 시 바꿔주는 클래스 -->
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% String directory= application.getRealPath("upload");
int maxSize = 1024*1024*100;
String encoding = "UTF-8";

MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, 
			new DefaultFileRenamePolicy());

String fileName = multipartRequest.getOriginalFileName("file");
String fileRealName = multipartRequest.getFilesystemName("file");


out.write("파일명:"+ fileName + "<br>");
out.write("실제 파일명:" + fileRealName+"<br>");
out.write(directory);
%>

<form action="WEB-INF/view/newArticleForm.jsp">
<input type="hidden" name="file" value=<%=fileName %>>
<input type="submit" value="첨부">
</form>
</body>
</html>