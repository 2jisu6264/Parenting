package article.dao;
import article.model.ArticleFile;
import article.model.ArticleBean;
import article.model.ArticleContentBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javaBean.SimpleBean;
import jdbc.JdbcUtil;

public class ArticleFileDao {
	

	public ArticleFile insertFile( Connection conn, ArticleFile articleFile) throws SQLException{
				PreparedStatement pstmt = null;
				try {
					pstmt = conn.prepareStatement(
							"insert into article_file values(?,?)");
					pstmt.setLong(1, articleFile.getNumber());
					pstmt.setString(2, articleFile.getFile());
					int insertedCount = pstmt.executeUpdate();
					if (insertedCount > 0) {
						return articleFile;
					} else {
						return null;
					}
				} finally {
					JdbcUtil.close(pstmt);
				}		
	
			}
	
	public ArticleFile selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from article_file where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArticleFile file = null;
			if (rs.next()) {
				file = new ArticleFile(
						rs.getInt("article_no"), rs.getString("file"));
			}
			return file;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	

	public int update(Connection conn, int no, String file) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update article_file set file= ? "+
						"where article_no = ?")) {
			pstmt.setString(1, file);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
	
}

