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
		
		ArticlePage articlePage; //19.02.18 08:48am �߰� by����
		if (searchItem.equals("")) {  //�˻��� ������ ��� searchItem�� null����
			articlePage = listService.getArticlePage(pageNo);
		}
		else {
			articlePage = listService.getSearchedArticlePage(pageNo,searchItem,option);
		}
		
		req.setAttribute("search", searchItem); //listArticle.jsp���� ${search}�� ��밡����
		req.setAttribute("option", option); //listArticle.jsp���� ${option}���� ��밡����
		req.setAttribute("articlePage", articlePage);
		return "/WEB-INF/view/listArticle.jsp";
	}

}
