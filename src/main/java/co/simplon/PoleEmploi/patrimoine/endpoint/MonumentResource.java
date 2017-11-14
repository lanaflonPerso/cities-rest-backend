package co.simplon.PoleEmploi.patrimoine.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import co.simplon.PoleEmploi.patrimoine.dao.MonumentDao;
import co.simplon.PoleEmploi.patrimoine.modele.Monument;

@Path("/monuments")
@RequestScoped
public class MonumentResource {

	protected static int DEFAULT_PAGE_SIZE = 10;

	@Inject
	private MonumentDao monumentDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Monument> getMonuments(@QueryParam("from") Integer from,
			@QueryParam("limit") Integer limit) {
		if (from == null) {
			from = 0;
		}
		if (limit == null) {
			limit = DEFAULT_PAGE_SIZE;
		}
		List<Monument> monuments = monumentDao.findAll(from, limit);
		return monuments;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMonumentById(@PathParam("id") Long id) {
		Monument monument = monumentDao.getMonumentById(id);
		if (monument != null)
			return Response.ok(monument).build();
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMonument(@PathParam("id") Long id, Monument monumentAModifier) {
		monumentAModifier.setIdentifiant(id);
		monumentDao.updateMonument(monumentAModifier);
		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	public void deleteMonumentById(@PathParam("id") Long id) {
		if (id == null) {
			throw new IllegalArgumentException("L'id doit être renseigné");
		}
		monumentDao.deleteMonumentById(id);
	}

	public void setMonumentDao(MonumentDao monumentDao) {
		this.monumentDao = monumentDao;
	}
}
