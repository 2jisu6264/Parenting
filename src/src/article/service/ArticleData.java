package article.service;

import article.model.ArticleBean;
import article.model.ArticleContentBean;

public class ArticleData {

	private ArticleBean article;
	private ArticleContentBean content;

	public ArticleData(ArticleBean article, ArticleContentBean content) {
		this.article = article;
		this.content = content;
	}

	public ArticleBean getArticle() {
		return article;
	}

	public String getContent() {
		return content.getContent();
	}

}
