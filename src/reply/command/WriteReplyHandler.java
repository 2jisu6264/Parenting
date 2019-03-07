package reply.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.WriterBean;
import reply.service.ReplyPage;
import reply.service.WriteReplyService;
import reply.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class WriteReplyHandler implements CommandHandler {
	//private static final String FORM_VIEW = "/WEB-INF/view/newReplyForm.jsp";
	private WriteReplyService writeService = new WriteReplyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		/*if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else */if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	/*
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}*/
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		int ArticleNum = Integer.parseInt(req.getParameter("no"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User)req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return "read.do?no="+ArticleNum;
		}
		
		int newReplyNo = writeService.write(writeReq, ArticleNum);
		req.setAttribute("newReplyNo", newReplyNo);
		
		return "read.do?no="+ArticleNum;
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				new WriterBean(user.getId(), user.getName()),
				req.getParameter("no"),
				req.getParameter("content"));
	}
	/*
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		int ArticleNum = Integer.parseInt(req.getParameter("Article_no"));
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ReplyPage ReplyList = writeService.getReplyPage(ArticleNum,pageNo);
		
		req.setAttribute("ReplyList", ReplyList);
		return "read.do?no="+pageNo;
	}*/
}
