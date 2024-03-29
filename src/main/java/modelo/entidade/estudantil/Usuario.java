package modelo.entidade.estudantil;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nome_usuario", length = 45, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "login_usuario", length = 30, nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha_usuario", length = 30, nullable = false, unique = false)
	private String senha;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		setId(id);
	}
	
	public Usuario(String nome, String login, String senha)  {
		setNome(nome);
		setLogin(login);
		setSenha(senha);
	}
	
	public Usuario(Long id, String nome, String login, String senha, Contato contato)  {
		setId(id);
		setNome(nome);
		setLogin(login);
		setSenha(senha);
	}
	
	public Usuario(Long id, String nome, String login, String senha)  {
		setId(id);
		setNome(nome);
		setLogin(login);
		setSenha(senha);
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login)  {

		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha)  {
	
		this.senha = senha;
	}

}
