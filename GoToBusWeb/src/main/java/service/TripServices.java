package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Trip;
import ejbs.User;
import ejbs.Station;


@Stateless
@Path("trips")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TripService{
	
	@PersistenceContext(unitName="hello")
    private EntityManager em;
	
	
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
	public List<Trip> getTrips(Trip trip, Station station)
	{
		int from_station = station.getFrom_station();
		int to_station = station.getTo_station();
		StationService s = new StationService();
		//Station station1 = s.getStation(Station.getFrom_station());
		//Station station2 = s.getStation(Station.getTo_station());
		Query query = em.createQuery("SELECT t FROM Trip t where t.departure_time >=?1 and t.arrival_time <=?2 and t.from_station = :from_station and t.to_station = :to_station",Trip.class);
		query.setParameter(1, trip.getFrom_date());                    
		query.setParameter(2, trip.getTo_date());
	    query.setParameter("from_station", s.getStation(from_station));
		query.setParameter("to_station", s.getStation(to_station));
		return query.getResultList();
	}
	
	
	


//	@POST
//	@Path("booktrip")
//	public void bookATrip()
//	{
//		TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t where trip_id >=?1 and user_id <=?2 ", Trip.class);
//		
//	}
	
	
	
	
	
	
	
	
	
}