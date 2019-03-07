package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {

   private ListArticleService listService = new ListArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		String searchItem = "";
		String option = req.getParameter("option");
		if(req.getParameter("search") != null) {
			searchItem = ""+req.getParameter("search");
		}		
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ArticlePage articlePage; //19.02.18 08:48am 추가 by혜린
		if (searchItem.equals("")) {  //검색을 안했을 경우 searchItem은 null값임
			articlePage = listService.getArticlePage(pageNo);
		}
		else {
			articlePage = listService.getSearchedArticlePage(pageNo,searchItem,option);
		}
		
		req.setAttribute("search", searchItem); //listArticle.jsp에서 ${search}로 사용가능함
		req.setAttribute("option", option); //listArticle.jsp에서 ${option}으로 사용가능함
		req.setAttribute("articlePage", articlePage);
		return "/WEB-INF/view/listArticle.jsp";
	}

}
