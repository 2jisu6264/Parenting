package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.ArticleContentBean;
import jdbc.connection.ConnectionProvider;

public class DeleteArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void deleteArticle(int articleNum) {
		try (Connection conn = ConnectionProvider.getConnection()){
			int delete = articleDao.deleteById(conn, articleNum);
			if (delete == 0) {
				throw new ArticleNotFoundException();
			}
			int success = contentDao.deleteById(conn, articleNum);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
