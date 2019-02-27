package article.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Date;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.ArticleBean;
import article.model.ArticleContentBean;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import article.dao.ArticleFileDao;
import article.model.ArticleFile;

public class WriteArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	private ArticleFileDao fileDao = new ArticleFileDao();
	
	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			ArticleBean article = toArticle(req);
			ArticleBean savedArticle = articleDao.insert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			ArticleContentBean content = new ArticleContentBean(
					savedArticle.getNumber(),
					req.getContent());
			
			ArticleContentBean savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert article_content");
			}

			ArticleFile file = new ArticleFile(
					savedArticle.getNumber(), 
					req.getFile());
			
			ArticleFile savedfile = fileDao.insertFile(conn, file);
			if (savedfile == null) {
				throw new RuntimeException("fail to insert file");
			}
			
			conn.commit();

			return savedArticle.getNumber();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private ArticleBean toArticle(WriteRequest req) {
		Date now = new Date();
		return new ArticleBean(null, req.getWriter(), req.getTitle(), now, now, 0);
	}
}
