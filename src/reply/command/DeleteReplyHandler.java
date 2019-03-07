package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.service.ReplyContentNotFoundException;
import reply.service.ReplyData;
import reply.service.ReplyNotFoundException;
import reply.service.DeleteReplyService;
import mvc.command.CommandHandler;

public class DeleteReplyHandler implements CommandHandler {

	private DeleteReplyService DeleteService = new DeleteReplyService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int ReplyNum = Integer.parseInt(noVal);
		
		try {
			DeleteService.deleteReply(ReplyNum);
			return "/WEB-INF/view/deleteSuccess.jsp";
		} catch (ReplyNotFoundException | ReplyContentNotFoundException e) {
			req.getServletContext().log("no Reply", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
