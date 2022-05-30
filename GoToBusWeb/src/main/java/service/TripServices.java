package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.Trip;

@Stateless
@Path("trips")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TripServices {
	
	@PersistenceContext(unitName="hello")
    private EntityManager em;
	
	@EJB
	Trip trip;
	
	@POST
	@Path("createtrip")
	public void createTrip(Trip Trip)
	{
		try
		{
		
			em.persist(Trip);
		}
		catch(EJBException e)
		{
			throw new EJBException(e);
		}
		
	}
	
	@GET
	@Path("gettrips")
	public List<Trip> getTrips()
	{
		TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t",Trip.class);
		return query.getResultList();
	}
	


	@POST
	@Path("booktrip")
	public void bookATrip()
	{
		TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t where trip_id >=?1 and user_id <=?2 ", Trip.class);
		
	}
	
	
	
	
	
	
	
	
	
}