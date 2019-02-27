package article.model;

public class ArticleContentBean {

	private Integer number;
	private String content;

	public ArticleContentBean(Integer number, String content) {
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
