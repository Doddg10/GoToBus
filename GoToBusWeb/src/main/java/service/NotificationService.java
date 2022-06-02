package service;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Notification;
import ejbs.Station;
import ejbs.Trip;
import ejbs.User;

@Stateless
@Path("notification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationService {
	
	@PersistenceContext(unitName="hello")
    private EntityManager em;
	
	@GET
	@Path("getnotifications")
	public List<Notification> getTrips()
	{
		TypedQuery<Notification> query = em.createQuery("SELECT n FROM Notification n",Notification.class);
		return query.getResultList();
	}
	
	@GET
	@Path("notifications/{user_id}")
	public Set<Notification> getNotification(@PathParam("user_id")int id)
	{
		User user = em.find(User.class, id);
		return user.getNotification();
	}

}