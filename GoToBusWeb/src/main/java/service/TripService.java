package service;

import java.util.List; 
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Trip;
import ejbs.Station;


@Stateless
@Path("trips")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TripService{
	
	@PersistenceContext(unitName="hello")
    private EntityManager em;
	@PersistenceContext(unitName="hello")
	private EntityManager em2;
	@PersistenceContext(unitName="hello")
	private EntityManager em3;
	
	
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
	@Path("gettrips1")
	public List<Trip> getTrips()
	{
		TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t",Trip.class);
		return query.getResultList();
	}
	
	
	@POST
	@Path("gettrips2")
	public List<Trip> getTrips(Trip trip)
	{		
		String from_station = trip.getFrom_station();
		String to_station = trip.getTo_station();
		int x = Integer.parseInt(from_station);
		int y = Integer.parseInt(to_station);
		Station s1= em.find(Station.class, x);
		Station s2= em.find(Station.class, y);

		Query query = em.createQuery("SELECT t FROM Trip t where t.departure_time >=?1 and t.arrival_time <=?2 and t.from_station = ?3 and t.to_station = ?4");	
		query.setParameter(1, trip.getFrom_date());                    
		query.setParameter(2, trip.getTo_date());	
		query.setParameter(3, s1.getName());
		query.setParameter(4, s2.getName());
	
		List <Trip> trips = (List<Trip>) query.getResultList();
		return trips;
	}
		
}