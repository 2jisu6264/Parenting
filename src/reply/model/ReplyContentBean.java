package reply.model;

public class ReplyContentBean {

	private Integer number;
	private String content;

	public ReplyContentBean(Integer number, String content) {
		this.number = number;
		this.content = content;
	}

	public Integer getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}

}
