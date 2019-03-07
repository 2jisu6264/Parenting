package reply.service;

import java.util.Map;

import reply.model.WriterBean;

public class WriteRequest {

	private WriterBean writer;
	private String articleNum;
	private String content;

	public WriteRequest(WriterBean writer, String articleNum, String content) {
		this.writer = writer;
		this.articleNum = articleNum;
		this.content = content;
	}

	public WriterBean getWriter() {
		return writer;
	}

	public String getarticleNum() {
		return articleNum;
	}

	public String getContent() {
		return content;
	}

	public void validate(Map<String, Boolean> errors) {
		if (content == null || content.trim().isEmpty()) {
			errors.put("content", Boolean.TRUE);
		}
	}
}
