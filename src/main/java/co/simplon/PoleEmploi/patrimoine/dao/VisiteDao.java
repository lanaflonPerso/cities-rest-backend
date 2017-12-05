package co.simplon.PoleEmploi.patrimoine.dao;

import java.util.List;

import co.simplon.PoleEmploi.patrimoine.modele.Visite;

public interface VisiteDao {
	List<Visite> findAllForMonumentId(Long monumentId, int first, int size);
}
