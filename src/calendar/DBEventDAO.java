package calendar;
import java.sql.*;
import java.util.ArrayList;

public class DBEventDAO implements EventDAO{
	private String jdbc_driver = "com.mysql.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	private Connection conn;
	private Statement stmt;
	
	private void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "root", "rootpw");
			stmt = conn.createStatement();
		}catch(Exception e) {
			
		}
	}
	private void disconnect() {
		try {
			stmt.close();
			conn.close();
		}catch(Exception e) {
		}
	}
	public void addEvent(EventBean event)
	{
		String sql = "insert into event values('"
				+ event.getId() + "' , '"
				+ event.getName() + "' , '"
				+ event.getDate() + "' , '"
				+ event.getPlace() + "')";
		try {
			connect();
			stmt.executeUpdate(sql);
			disconnect();
		}catch(Exception e) {
			
		}
	}
	
	public ArrayList<EventBean> getAllEvent(){
		String sql = "select id, name, date, place from event";
		ArrayList<EventBean> list = new ArrayList<EventBean>();
		try {
			connect();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				EventBean event = new EventBean();
				event.setId(rs.getInt("fairid"));
				event.setName(rs.getString("fairname"));
				event.setDate(rs.getDate("fairdate"));
				event.setPlace(rs.getString("fairplace"));
				list.add(event);
			}
			rs.close();
			disconnect();
		}catch(Exception e) {}
		return list;
	}
	
	public EventBean getEvent(String id) {
		String sql = "select id, name, date, place from event where id = "+ id;
		EventBean event = new EventBean();
		try {
			connect();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			event.setId(rs.getInt("fairid"));
			event.setName(rs.getString("fairname"));
			event.setDate(rs.getDate("fairdate"));
			event.setPlace(rs.getString("fairplace"));
			rs.close();
			disconnect();
		}catch(Exception e) {}
		return event;
	}
}
