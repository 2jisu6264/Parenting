<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import= "java.io.File" %>
<%@ page import = "java.io.FileInputStream" %>
<%@ page import = "javax.servlet.ServletOutputStream"%>
<%@ page import ="javax.servlet.ServletContext"%>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
String fileName = request.getParameter("file");

//아래처럼 파일의 경로 얻을 수 있음.
ServletContext context = getServletContext();
String downloadPath = context.getRealPath("upload");

//String mimeType = getServletContext().getMimeType(fileName.toString());
//파일의 타입 판단은 mimeType.
//if(mimeType == null) {
//	mimeType ="application/octet-stream"; //2진 데이터 전달.
//}

File file = new File(downloadPath + "/" +fileName);

//헤더 설정
response.setContentType("Application/x-msdownload"); //다운로드 문서형식으로 내보냄.
response.setHeader("Content-Disposition", "attachment; filename= "+ 
	URLEncoder.encode(fileName, "utf-8"));// 다운로드 파일 설정.
if(file.isFile())
try{
//스트림 통로.
ServletOutputStream out2 = response.getOutputStream();
FileInputStream in = new FileInputStream(file);
int numRead;
byte b[] = new byte[1024];

while((numRead = in.read( b , 0, b.length))!= -1)
	out2.write(b, 0, numRead);

out2.flush();
out2.close();
in.close();
}catch(Exception e){
	e.printStackTrace();
}
%>
	
</body>
</html>