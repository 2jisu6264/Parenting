package article.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.ServletOutputStream;

public class ArticleFileDownload extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String save = "upload";
		ServletContext context = getServletContext();
		String downloadPath = context.getRealPath(save);
		
		String file = request.getParameter("file");
		String fileName = downloadPath+"/" + file;
		
		String mimeType = getServletContext().getMimeType(file.toString());
		//파일의 타입 판단은 mimeType.
		if(mimeType == null) {
			mimeType ="application/octet-stream"; //2진 데이터 전달.
		}
		
		String downloadName=null;
		String agent = request.getHeader("User-Agent");
		if(agent.indexOf("MSIE")>-1) { //윈도우에 따라 다르게 만들어진.
		 downloadName= new String(fileName.getBytes("UTF-8"),"8859_1");
		}else {
			downloadName = new String(fileName.getBytes("UTF-8"),"iso_8859_1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename= "+downloadName);
		
		//fileinputstream으로 read한 만큼 ServletOutputStream으로 빼내야함.
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(fileName);
		int numRead;
		byte b[] = new byte[1024];
		
		while((numRead = in.read( b , 0, b.length))!= -1)
			out.write(b, 0, numRead);
		
		out.flush();
		in.close();
	}
}
