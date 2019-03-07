package reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

//import reply.dao.ReplyContentDao;
import reply.dao.ReplyDao;
import reply.model.ReplyBean;
//import reply.model.ReplyContentBean;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteReplyService {

	private ReplyDao ReplyDao = new ReplyDao();
	//private ReplyContentDao contentDao = new ReplyContentDao();

	public Integer write(WriteRequest req, int ArticleNum) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			ReplyBean Reply = toReply(req, ArticleNum);
			ReplyBean savedReply = ReplyDao.insert(conn, Reply);
			if (savedReply == null) {
				throw new RuntimeException("fail to insert Reply");
			}
			/*ReplyContentBean content = new ReplyContentBean(
					savedreply.getNumber(),
					req.getContent());
			ReplyContentBean savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert Reply_content");
			}*/

			conn.commit();
			
			return savedReply.getNumber();
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

	private ReplyBean toReply(WriteRequest req, int ArticleNum) {
		Date now = new Date();
		return new ReplyBean(null, ArticleNum, req.getWriter(), req.getContent(), now, now);
	}
}
