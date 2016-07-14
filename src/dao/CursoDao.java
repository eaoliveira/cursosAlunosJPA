package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Aluno;
import modelo.Curso;

@Stateless
public class CursoDao {
	@PersistenceContext(name = "CursosJpa")
	private  EntityManager manager;

	private Logger logger;
	
	public CursoDao() {
		logger = Logger.getLogger("dao.CursoDao");
	}
	
	public void adiciona(Curso obj) {
		manager.merge(obj);
	}
	
	public void adiciona(Aluno obj) {
		manager.merge(obj);
	}

	public void remove(int id) {
		Curso obj = manager.find(Curso.class, id);
		if (obj != null)
			manager.remove(obj);
	}
	public void removeAluno(int id) {
		Aluno obj = manager.find(Aluno.class, id);
		if (obj != null)
			manager.remove(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Curso> getCursos() {
		Query sql = manager.createQuery("from Curso", Curso.class);
		logger.warning("sql: " + sql);
		List<Curso> lista = sql.getResultList();
		logger.warning("lista: " + lista.size());
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAluno() {
		Query sql = manager.createQuery("from Aluno", Aluno.class);
		logger.warning("sql: " + sql);
		List<Aluno> lista = sql.getResultList();
		logger.warning("lista: " + lista.size());
		return lista;
	}

	public long getCount() {

		return manager.createQuery("select count(obj) from Curso", long.class).getSingleResult();

		// return getCursos().size();
	}
}
