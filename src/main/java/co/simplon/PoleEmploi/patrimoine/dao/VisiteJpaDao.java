package co.simplon.PoleEmploi.patrimoine.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.simplon.PoleEmploi.patrimoine.modele.Visite;

@Named
public class VisiteJpaDao implements VisiteDao {

	@Inject
	private EntityManager entityManager;

	public VisiteJpaDao() {
		super();
	}

	@Override
	public List<Visite> findAllForMonumentId(Long monumentId, int first,
			int size) {
		return entityManager
				.createNamedQuery("Visite.findAllByMonumentId", Visite.class)
				.setParameter("id", monumentId).setFirstResult(first)
				.setMaxResults(size).getResultList();
	}
	
	

}
