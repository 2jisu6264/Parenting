package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.service.ReplyPage;
import reply.service.ListReplyService;
import mvc.command.CommandHandler;

public class ListReplyHandler implements CommandHandler {

	private ListReplyService listService = new ListReplyService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		int ArticleNum = Integer.parseInt(req.getParameter("Article_no"));
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ReplyPage ReplyList = listService.getReplyPage(ArticleNum,pageNo);
		
		req.setAttribute("ReplyList", ReplyList);
		return "read.do?no="+pageNo;
	}

}
