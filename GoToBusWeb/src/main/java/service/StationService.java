package service;


import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ejbs.Station;


@Stateless

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("stations")
public class StationService {
	
	@PersistenceContext(unitName="GoToBus")
    private EntityManager em;
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("station")
	public boolean CreateStation(Station station) {
		try
		{
			
			em.persist(station);
			return true;
		}
		catch(Exception e) {
			throw new EJBException(e);
		} 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("station/{id}")
	public Station getStation(@PathParam("id")int id)
	{
		
		return em.find(Station.class, id);
	}


	}   


