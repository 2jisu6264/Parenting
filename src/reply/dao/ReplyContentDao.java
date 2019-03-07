package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import reply.model.ReplyContentBean;
import jdbc.JdbcUtil;

public class ReplyContentDao {

	public ReplyContentBean insert(Connection conn, ReplyContentBean content) 
	throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"insert into Reply_content " + 
					"(Reply_no, content) values (?,?)");
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public ReplyContentBean selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Reply_content where Reply_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ReplyContentBean content = null;
			if (rs.next()) {
				content = new ReplyContentBean(
						rs.getInt("Reply_no"), rs.getString("content"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int deleteById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"delete from Reply_content where Reply_no = ?");
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public int update(Connection conn, int no, String content) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update Reply_content set content = ? "+
						"where Reply_no = ?")) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
