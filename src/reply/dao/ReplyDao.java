package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import reply.model.ReplyBean;
import reply.model.WriterBean;
import jdbc.JdbcUtil;

public class ReplyDao {

	public ReplyBean insert(Connection conn, ReplyBean Reply) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into reply "
					+ "(article_no, writer_id, writer_name, content, regdate, moddate) "
					+ "values (?,?,?,?,?,?)");
			pstmt.setString(1, Reply.getArticleNum().toString());
			pstmt.setString(2, Reply.getWriter().getId());
			pstmt.setString(3, Reply.getWriter().getName());
			pstmt.setString(4, Reply.getContent());
			pstmt.setTimestamp(5, toTimestamp(Reply.getRegDate()));
			pstmt.setTimestamp(6, toTimestamp(Reply.getModifiedDate()));

			
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	//��ü �Խñۼ� ���ϴ� �޼���
	public int selectCount(Connection conn, int articleNum) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from reply where (article_no like "+articleNum+")");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	/*//���� ���⼭ ���ٸ� �� ��� ã�� ����� �߰������� �ʿ��ҵ�?
	public List<ReplyBean> search(Connection conn, int startRow, int size, String searchItem, String option) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchItem_ch = "%"+searchItem+"%";
		try {
			switch(option) {
			case "����":
				pstmt = conn.prepareStatement("select * from Reply"
						+ " where(title like ?)"
						+ " order by Reply_no desc limit ?, ?");
				break;
			case "�ۼ���":
					pstmt = conn.prepareStatement("select * from Reply"
							+ " where(writer_name like ?)"
							+ " order by Reply_no desc limit ?, ?");
				break;
			case "����":
					pstmt = conn.prepareStatement("select reply.* from Reply"
							+ " as Reply left join Reply_content on"
							+ " (reply.Reply_no = Reply_content.Reply_no)"
							+ " where(Reply_content.content like ?)"
							+ " order by Reply_no desc limit ?, ?");
					break;
			default:
				break;
			}
			pstmt.setString(1, searchItem_ch);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, size);
			rs = pstmt.executeQuery();
			List<ReplyBean> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReply(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
	}*/

	//Ư�� �Խñ��� ��� �о���� �޼���(*no_desc�� ��ȣ ����, limit�� ?+1������ ?�������� ��)
	public List<ReplyBean> select(Connection conn, int startRow, int size, int articleNum) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from reply "
					+ "where article_no = ?"
					+" order by reply limit ?, ?");
			pstmt.setInt(1, articleNum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, size);
			rs = pstmt.executeQuery();
			List<ReplyBean> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReply(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private ReplyBean convertReply(ResultSet rs) throws SQLException {
		return new ReplyBean(rs.getInt("reply_no"),
				rs.getInt("article_no"),
				new WriterBean(
						rs.getString("writer_id"),
						rs.getString("writer_name")),
				rs.getString("content"),
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public ReplyBean selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from reply where reply_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ReplyBean Reply = null;
			if (rs.next()) {
				Reply = convertReply(rs);
			}
			return Reply;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//��ȣ�� �Խñ� �����ϴ� �޼���
	public int deleteById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"delete from Reply where reply_no = ?");
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	
	}
	
	public int update(Connection conn, int no, String content) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update Reply set content = ?, moddate = now() "+
						"where Reply_no = ?")) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
