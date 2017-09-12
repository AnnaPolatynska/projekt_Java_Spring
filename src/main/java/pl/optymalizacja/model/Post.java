package pl.optymalizacja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String content;
	private String sign;
	//gettery i settery dla id, tytułu treści i podpisu
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	//konstruktory domyślny i wykorzytujący id, tytuł treść i podpis
	public Post(){}
	public Post(long id, String title, String content, String sign) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.sign = sign;
	}
}
