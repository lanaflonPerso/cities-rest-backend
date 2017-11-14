package co.simplon.PoleEmploi.patrimoine.endpoint;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import co.simplon.PoleEmploi.patrimoine.dao.MonumentDao;
import co.simplon.PoleEmploi.patrimoine.dao.MonumentMockDao;
import co.simplon.PoleEmploi.patrimoine.modele.Monument;

public class MonumentResourceTest {

	private List<Monument> getMockedList(int expectedSize) {
		// résultat du mock
		List<Monument> monumentsFromDao = new ArrayList<>();
		for (int i = 0; i < expectedSize; i++) {
			monumentsFromDao.add(new Monument());
		}
		return monumentsFromDao;
	}
	
	@Test
	public void with_Mockito_getMonuments_should_return_DEFAULT_PAGE_SIZE_items_when_from_and_limit_are_both_null() {
		// GIVEN
		MonumentResource resource = new MonumentResource();
		// Mockito : crée moi à la volée une implémentation de MonumentDao
		MonumentDao dao = Mockito.mock(MonumentDao.class);
		resource.setMonumentDao(dao);
		Integer from = null;
		Integer limit = null;

		// WHEN
		// Mockito : définit le comportement du mock dao dans le cas d'un appel
		// de findAll
		Mockito.when(dao.findAll(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(getMockedList(MonumentResource.DEFAULT_PAGE_SIZE));
		List<Monument> monuments = resource.getMonuments(from, limit);

		// THEN
		// Mockito : vérifie que le mock dao a été appelé avec les arguments attendus
		Mockito.verify(dao).findAll(Mockito.eq(0), Mockito.eq(MonumentResource.DEFAULT_PAGE_SIZE));
		assertEquals(MonumentResource.DEFAULT_PAGE_SIZE, monuments.size());
	}

	@Test
	public void getMonuments_should_return_DEFAULT_PAGE_SIZE_items_when_from_and_limit_are_both_null() {
		// GIVEN
		MonumentResource resource = new MonumentResource();
		MonumentDao dao = new MonumentMockDao();
		resource.setMonumentDao(dao);
		Integer from = null;
		Integer limit = null;

		// WHEN
		List<Monument> monuments = resource.getMonuments(from, limit);

		// THEN
		assertEquals(MonumentResource.DEFAULT_PAGE_SIZE, monuments.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteMonumentById_should_throw_IllegalArgumentException_when_id_is_null() {
		// GIVEN
		Long id = null;
		MonumentResource resource = new MonumentResource();

		// WHEN
		resource.deleteMonumentById(id);

		// THEN : cf. annotation
	}

}
