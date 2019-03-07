package article.service;

import java.util.Map;

import article.model.WriterBean;

public class WriteRequest {

	private WriterBean writer;
	private String title;
	private String content;
	private String file;
	
	public WriteRequest(WriterBean writer, String title, String content,String file) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.file = file;
	}

	public WriterBean getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public String getFile() {
		return file;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
