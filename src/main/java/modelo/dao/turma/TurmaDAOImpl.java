package modelo.dao.turma;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.estudantil.Escola;
import modelo.entidade.estudantil.Turma;
import modelo.factory.conexao.ConexaoFactory;


public class TurmaDAOImpl implements TurmaDAO{

	private ConexaoFactory fabrica;

	public TurmaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirTurma(Turma turma) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(turma);

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

	public void deletarTurma(Turma turma) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(turma);

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

	public void atualizarTurma(Turma turma) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(turma);

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
	
	public Turma recuperarTurma(Turma turma) {

		Session sessao = null;
		Turma turmaRecuperado = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
			Root<Turma> raizTurma = criteria.from(Turma.class);

			criteria.select(raizTurma);
			
			ParameterExpression<Long> idTurma= construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizTurma.get("id"), idTurma));

			turmaRecuperado = sessao.createQuery(criteria).setParameter(idTurma, turma.getId()).getSingleResult();

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

		return turmaRecuperado;
	}
	
	public List<Turma> recuperarTurmas() {

		Session sessao = null;
		List<Turma> turmas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
			Root<Turma> raizTurma = criteria.from(Turma.class);

			criteria.select(raizTurma);

			turmas = sessao.createQuery(criteria).getResultList();

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

		return turmas;
	}
	
	public List<Turma> recuperarTurmasEscola (Escola escola) {
			
			Session sessao = null;
			List<Turma> turmas = null;

			try {

				sessao = fabrica.getConexao().openSession();
				sessao.beginTransaction();

				CriteriaBuilder construtor = sessao.getCriteriaBuilder();

				CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
				Root<Turma> raizTurma = criteria.from(Turma.class);
				
				Join<Turma, Escola> juncaoEscola = raizTurma.join("escola");
				
				ParameterExpression<Long> idEscola = construtor.parameter(Long.class);
				criteria.where(construtor.equal(juncaoEscola.get("turmas"), idEscola));

				turmas = sessao.createQuery(criteria).setParameter(idEscola, escola.getId()).getResultList();

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

			return turmas;
		}
}
