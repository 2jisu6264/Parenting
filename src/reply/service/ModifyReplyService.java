package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import reply.dao.ReplyContentDao;
import reply.dao.ReplyDao;
import reply.model.ReplyBean;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyReplyService {

	private ReplyDao ReplyDao = new ReplyDao();
	private ReplyContentDao contentDao = new ReplyContentDao();

	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			ReplyBean Reply = ReplyDao.selectById(conn, 
					modReq.getReplyNumber());
			if (Reply == null) {
				throw new ReplyNotFoundException();
			}
			if (!canModify(modReq.getUserId(), Reply)) {
				throw new PermissionDeniedException();
			}
			ReplyDao.update(conn, 
					modReq.getReplyNumber(), modReq.getTitle());
			contentDao.update(conn, 
					modReq.getReplyNumber(), modReq.getContent());
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(String modfyingUserId, ReplyBean Reply) {
		return reply.getWriter().getId().equals(modfyingUserId);
	}
}
