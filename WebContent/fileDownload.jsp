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

//�Ʒ�ó�� ������ ��� ���� �� ����.
ServletContext context = getServletContext();
String downloadPath = context.getRealPath("upload");

//String mimeType = getServletContext().getMimeType(fileName.toString());
//������ Ÿ�� �Ǵ��� mimeType.
//if(mimeType == null) {
//	mimeType ="application/octet-stream"; //2�� ������ ����.
//}

File file = new File(downloadPath + "/" +fileName);

//��� ����
response.setContentType("Application/x-msdownload"); //�ٿ�ε� ������������ ������.
response.setHeader("Content-Disposition", "attachment; filename= "+ 
	URLEncoder.encode(fileName, "utf-8"));// �ٿ�ε� ���� ����.
if(file.isFile())
try{
//��Ʈ�� ���.
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