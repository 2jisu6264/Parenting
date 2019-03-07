package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import reply.dao.ReplyContentDao;
import reply.dao.ReplyDao;
import reply.model.ReplyContentBean;
import jdbc.connection.ConnectionProvider;

public class DeleteReplyService {

	private ReplyDao ReplyDao = new ReplyDao();
	private ReplyContentDao contentDao = new ReplyContentDao();
	
	public void deleteReply(int ReplyNum) {
		try (Connection conn = ConnectionProvider.getConnection()){
			int delete = ReplyDao.deleteById(conn, ReplyNum);
			if (delete == 0) {
				throw new ReplyNotFoundException();
			}
			int success = contentDao.deleteById(conn, ReplyNum);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
