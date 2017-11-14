package co.simplon.PoleEmploi.patrimoine.dao;

import java.util.ArrayList;
import java.util.List;

import co.simplon.PoleEmploi.patrimoine.modele.Monument;

public class MonumentMockDao implements MonumentDao {

	@Override
	public List<Monument> findAll(int first, int size) {
		List<Monument> liste = new ArrayList<>();
		for (int i = 0 ; i < size ; i ++) {
			liste.add(new Monument());
		}
		return liste;
	}

	@Override
	public List<Monument> findAllForVilleId(Long idVille, int first, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monument getMonumentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMonumentById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Monument updateMonument(Monument monument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monument createMonumentForVille(Monument monument, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
