package javaBean;
import javaBean.SimpleBean;
import java.sql.*;

public class javaDao {
	public Connection getConnection() {
		Connection conn = null;
		String jdbcDriver = "jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8&useUnicode=true";
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    String dbUser = "root";
		    String dbPass = "rootpw";
		 conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void insertIvent(SimpleBean SimpleBean) {
		try {
			Connection conn = this.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into calendar values(?,?,?,?,?,?)");
			pstmt.setString(1, SimpleBean.getYear());
			pstmt.setString(2, SimpleBean.getMonth());
			pstmt.setString(3, SimpleBean.getDay());
			pstmt.setString(4, SimpleBean.getName());
			pstmt.setString(5, SimpleBean.getPlace());
			pstmt.setString(6, SimpleBean.getUrl());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
