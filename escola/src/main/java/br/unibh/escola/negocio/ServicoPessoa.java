package br.unibh.escola.negocio;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.unibh.escola.entidades.Pessoa;
@Stateless
@LocalBean
public class ServicoPessoa implements DAO<Pessoa, Long> {
	@Inject
	EntityManager em;
	@Inject
	private Logger log;
	@Override
	public Pessoa insert(Pessoa t) throws Exception {
		log.info("Persistindo "+t);
		em.persist(t);
		return t;
	}
	@Override
	public Pessoa update(Pessoa t) throws Exception {
		log.info("Atualizando "+t);
		return em.merge(t);
	}
	@Override
	public void delete(Pessoa t) throws Exception {
		log.info("Removendo "+t);
		Object c = em.merge(t);
		em.remove(c);
	}
	@Override
	public Pessoa find(Long k) throws Exception {
		log.info("Encontrando Pessoa "+k);
		return em.find(Pessoa.class, k);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> findAll() throws Exception {
		log.info("Encontrando todos os Pessoas");
		return em.createQuery("from Pessoa").getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> findByName(String name) throws Exception {
		log.info("Encontrando Pessoas "+name);
		return em.createNamedQuery("Pessoa.findByName")
				.setParameter("nome", name+"%").getResultList();
	}
}