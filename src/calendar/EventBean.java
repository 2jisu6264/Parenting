package calendar;
import java.util.*;

public class EventBean {
	private int fairid;
	private String fairname;
	private  Date fairdate;
	private String fairplace;
	
	public int getId() {
		return fairid;
	}
	public void setId(int id) {
		this.fairid = id;
	}
	public String getName() {
		return fairname;
	}
	public void setName(String name)
	{
		this.fairname = name;
	}
	public Date getDate()
	{
		return fairdate;
	}
	public void setDate(Date date)
	{
		this.fairdate = date;
	}
	public String getPlace()
	{
		return fairplace;
	}
	public void setPlace(String place)
	{
		this.fairplace = place;
	}
}
