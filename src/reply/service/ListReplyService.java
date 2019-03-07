package reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import reply.dao.ReplyDao;
import reply.model.ReplyBean;
import jdbc.connection.ConnectionProvider;

public class ListReplyService {

	private ReplyDao ReplyDao = new ReplyDao();
	private int size = 10;
	
	//게시글 검색 기능 추가(19.02.01 1:39pm by혜린)
	/*
	public ReplyPage getSearchedReplyPage(int pageNum, String writer_name, String title) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = ReplyDao.selectCount(conn);
			List<ReplyBean> content = ReplyDao.search(
					conn, writer_name, title);
			return new ReplyPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

	public ReplyPage getReplyPage(int articleNum, int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = ReplyDao.selectCount(conn, articleNum);
			List<ReplyBean> content = ReplyDao.select(
					conn, (pageNum - 1) * size, size, articleNum);
			return new ReplyPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	public ReplyPage getSearchedReplyPage(int pageNum, String searchItem, String option) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = ReplyDao.selectCount(conn);
			List<ReplyBean> content = ReplyDao.search(
					conn, (pageNum - 1) * size, size, searchItem, option);
			return new ReplyPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/


}
