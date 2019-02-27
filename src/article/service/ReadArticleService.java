package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.ArticleBean;
import article.model.ArticleContentBean;
import jdbc.connection.ConnectionProvider;
import article.dao.ArticleFileDao;
import article.model.ArticleFile;
public class ReadArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	private ArticleFileDao fileDao = new ArticleFileDao();
	
	public ArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			ArticleBean article = articleDao.selectById(conn, articleNum);
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			ArticleContentBean content = contentDao.selectById(conn, articleNum);
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			ArticleFile file = fileDao.selectById(conn, articleNum);
			//if(file == null)
			//{
			//	throw new FileContentNotFoundException();
			//}
			
			if (increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			return new ArticleData(article, content, file);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
