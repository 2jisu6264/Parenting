/*package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.service.ReplyContentNotFoundException;
import reply.service.ReplyData;
import reply.service.ReplyNotFoundException;
import reply.service.ReadReplyService;
import mvc.command.CommandHandler;

public class ReadReplyHandler implements CommandHandler {

	private ReadReplyService readService = new ReadReplyService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int ReplyNum = Integer.parseInt(noVal);
		try {
			ReplyData ReplyData = readService.getReply(writerNum, replyNum);
			req.setAttribute("ReplyData", ReplyData);
			return "/WEB-INF/view/readreply.jsp";
		} catch (ReplyNotFoundException | ReplyContentNotFoundException e) {
			req.getServletContext().log("no Reply", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
*/