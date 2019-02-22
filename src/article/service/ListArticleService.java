package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.ArticleBean;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	//게시글 검색 기능 추가(19.02.01 1:39pm by혜린)
	/*
	public ArticlePage getSearchedArticlePage(int pageNum, String writer_name, String title) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			List<ArticleBean> content = articleDao.search(
					conn, writer_name, title);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			List<ArticleBean> content = articleDao.select(
					conn, (pageNum - 1) * size, size);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArticlePage getSearchedArticlePage(int pageNum, String searchItem, String option) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			List<ArticleBean> content = articleDao.search(
					conn, (pageNum - 1) * size, size, searchItem, option);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
