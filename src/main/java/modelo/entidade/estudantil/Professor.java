package modelo.entidade.estudantil;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "professor")
public class Professor extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Um professor vai ter uma disciplina.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	public Professor() {}
	
	public Professor(Long id) {
		super(id);
	}
	
	public Professor(String nome, String login, String senha, Disciplina disciplina){ //throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException, LoginInvalidoException
		super(nome, login, senha);
		setDisciplina(disciplina);
	}
	
	public Professor(Long id, String nome, String login, String senha, Contato contato, Disciplina disciplina){ //throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException, LoginInvalidoException
		super(id, nome, login, senha, contato);
		setDisciplina(disciplina);
	}
	
	public Professor(Long id, String nome, String login, String senha){ //throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException, LoginInvalidoException
		super(id, nome, login, senha);
	}
	
	public Professor(String nome, String login, String senha){ //throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException, LoginInvalidoException
		super(nome, login, senha);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
