package article.service;

import article.model.ArticleBean;
import article.model.ArticleContentBean;
import article.model.ArticleFile;
public class ArticleData {

	private ArticleBean article;
	private ArticleContentBean content;
	private ArticleFile file;

	public ArticleData(ArticleBean article, ArticleContentBean content, ArticleFile file) {
		this.article = article;
		this.content = content;
		this.file = file;
	}

	public ArticleBean getArticle() {
		return article;
	}

	public String getContent() {
		return content.getContent();
	}

	public String getFile() {
		return file.getFile();
	}
}
