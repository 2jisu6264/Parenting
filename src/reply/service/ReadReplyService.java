/*package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import reply.dao.ReplyContentDao;
import reply.dao.ReplyDao;
import reply.model.ReplyBean;
import reply.model.ReplyContentBean;
import jdbc.connection.ConnectionProvider;

public class ReadReplyService {

	private ReplyDao ReplyDao = new ReplyDao();
//	private ReplyContentDao contentDao = new ReplyContentDao();
	
	public ReplyData getReply(int writerNum, int replyNum) {
		try (Connection conn = ConnectionProvider.getConnection()){
			ReplyBean reply = ReplyDao.selectById(conn, replyNum);
			if (reply == null) {
				throw new ReplyNotFoundException();
			}
			//ReplyContentBean content = contentDao.selectById(conn, ReplyNum);
			//if (content == null) {
			//	throw new ReplyContentNotFoundException();
			//}
			return new ReplyData(reply);
			//return new ReplyData(Reply, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
*/