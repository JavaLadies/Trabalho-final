package modelo.dao.disciplina;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.estudantil.Disciplina;
import modelo.entidade.estudantil.Turma;
import modelo.factory.conexao.ConexaoFactory;

public class DisciplinaDAOImpl implements DisciplinaDAO {

	private ConexaoFactory fabrica;

	public DisciplinaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirDisciplina(Disciplina disciplina) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(disciplina);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void deletarDisciplina(Disciplina disciplina) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(disciplina);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarDisciplina(Disciplina disciplina) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(disciplina);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}
	
	public Disciplina recuperarDisciplina(Disciplina disciplina) {

		Session sessao = null;
		Disciplina disciplinaRecuperada = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Disciplina> criteria = construtor.createQuery(Disciplina.class);
			Root<Disciplina> raizDisciplina = criteria.from(Disciplina.class);

			criteria.select(raizDisciplina);
			
			ParameterExpression<Long> idDisciplina= construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizDisciplina.get("id"), idDisciplina));

			disciplinaRecuperada = sessao.createQuery(criteria).setParameter(idDisciplina, disciplina.getId()).getSingleResult();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return disciplinaRecuperada;
	}

	public List<Disciplina> recuperarDisciplinas() {

		Session sessao = null;
		List<Disciplina> disciplinas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Disciplina> criteria = construtor.createQuery(Disciplina.class);
			Root<Disciplina> raizDisciplina = criteria.from(Disciplina.class);

			criteria.select(raizDisciplina);

			disciplinas = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return disciplinas;
	}
	
	public List<Disciplina> recuperarDisciplinasTurma(Turma turma) {

		Session sessao = null;
		List<Disciplina> disciplinas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Disciplina> criteria = construtor.createQuery(Disciplina.class);
			Root<Disciplina> raizDisciplina = criteria.from(Disciplina.class);

			Join<Disciplina, Turma> juncaoTurma = raizDisciplina.join("turmas");

			ParameterExpression<Long> idTurma = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoTurma.get("id"), idTurma));

			disciplinas = sessao.createQuery(criteria).setParameter(idTurma, turma.getId()).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return disciplinas;
	}
	
}