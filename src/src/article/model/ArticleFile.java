package src.article.model;

public class ArticleFile {
	private Integer number;
	private String file;

	public ArticleFile(Integer number, String file) {
		this.number = number;
		this.file = file;
	}

	public Integer getNumber() {
		return number;
	}

	public String getFile() {
		return file;
	}
}
