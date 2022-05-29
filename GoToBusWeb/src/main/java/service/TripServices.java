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
@Path("trip")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TripServices {
	
	@PersistenceContext()
	private EntityManager em;
	@EJB
	Trip trip;
	
	@POST
	@Path("trip")
	public void createTrip(Trip newTrip)
	{
		try
		{
//			Trip newTrip = new Trip();
			newTrip.setFromStation(trip.getFromStation());
			newTrip.setToStation(trip.getToStation());
			newTrip.setSeatsNum(trip.getSeatsNum());
			newTrip.setDepartureTime(trip.getDepartureTime());
			newTrip.setArrivalTime(trip.getArrivalTime());
			em.persist(newTrip);
		}
		catch(EJBException e)
		{
			throw new EJBException(e);
		}
		
	}
	
	@POST
	@Path("searchtrips")
	public List<Trip> searchTrips()
	{
		TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t where departure_time >=?1 and arrival_time <=?2 and from_station LIKE?3 and to_station LIKE?4", Trip.class);
		query.setParameter(1, trip.getDepartureTime());
		query.setParameter(2, trip.getArrivalTime());
		query.setParameter(3, trip.getFromStation());
		query.setParameter(4, trip.getToStation());
		return query.getResultList();
	}

	@POST
	@Path("booktrip")
	public void bookATrip()
	{
		TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t where trip_id >=?1 and user_id <=?2 ", Trip.class);
		
	}
	
	
	
	
	
	
	
	@GET
	@Path("hello")
	public String hello()
	{
		return "Hello";
	}
	
	
}
