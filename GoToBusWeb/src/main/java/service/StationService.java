package service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ejbs.Station;


@Stateless

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("stations")
public class StationService {
	
	@PersistenceContext(unitName="hello")
    private EntityManager em;
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("station")
	public String CreateStation(Station station) {
		try
		{
			//station.getName();
			//station.getLongitude();
			//station.getLatitude();
			em.persist(station);
			return "success";
		}
		catch(Exception e) {
			throw new EJBException(e);
		} 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("station/{id}")
	public List<Station> getStation(@PathParam("id")int id)
	{
		TypedQuery<Station> query1 = em.createQuery("SELECT name FROM STATION station where id =:id ", Station.class);
		query1.setParameter("id", id);
		List<Station> Stations = query1.getResultList();
		return Stations;
	}
	public String getStationLongtitude(int id) {
        return em.find(Station.class, id).getLongitude();
}
	public String getStationLatitude(int id) {
        return em.find(Station.class, id).getLatitude();
}
	

	}   


