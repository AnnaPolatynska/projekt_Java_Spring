package pl.optymalizacja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String login;
	private String password;
	//gettery i settery dla id, login i password
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//konstruktory domyślny i wykorzytujący id, login i password
	public Regist(){}
	public Regist(long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
}
