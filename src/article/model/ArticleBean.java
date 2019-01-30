package article.model;

import java.util.Date;

public class ArticleBean {

	private Integer number;
	private WriterBean writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;

	public ArticleBean(Integer number, WriterBean writer, String title, 
			Date regDate, Date modifiedDate, int readCount) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}

	public Integer getNumber() {
		return number;
	}

	public WriterBean getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}

}
