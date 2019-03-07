package reply.model;

import java.util.Date;

public class ReplyBean {

	private Integer number;
	private Integer articleNum;
	private WriterBean writer;
	private String content;
	private Date regDate;
	private Date modifiedDate;

	public ReplyBean(Integer number, Integer articleNum, WriterBean writer, String content, 
			Date regDate, Date modifiedDate) {
		this.number = number;
		this.articleNum = articleNum;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
	}

	public Integer getNumber() {
		return number;
	}
	
	public Integer getArticleNum() {
		return articleNum;
	}
	
	public WriterBean getWriter() {
		return writer;
	}

	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}
	

}
