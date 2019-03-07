package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;
//-----------------------------------
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

public class ReadArticleHandler implements CommandHandler {

	private ReadArticleService readService = new ReadArticleService();
	private WriteReplyService writeService = new WriteReplyService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);
			//=========
			/*Map<String, Boolean> errors = new HashMap<>();
			req.setAttribute("errors", errors);

			User user = (User)req.getSession(false).getAttribute("authUser");
			WriteRequest writeReq = createWriteRequest(user, req);
			writeReq.validate(errors);
			
			if (!errors.isEmpty()) {
				return "read.do?no="+noVal;
			}
			
			int newReplyNo = writeService.write(writeReq, articleNum);
			req.setAttribute("newReplyNo", newReplyNo);
				*/
			//=========
			return "/WEB-INF/view/readArticle.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}
	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				new WriterBean(user.getId(), user.getName()),
				req.getParameter("no"),
				req.getParameter("content"));
	}
}

