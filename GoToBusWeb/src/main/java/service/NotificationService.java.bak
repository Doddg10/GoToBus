package service;

import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ejbs.Notification;
import ejbs.User;

@Stateless
@Path("notification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationService {
	
	@PersistenceContext(unitName="GoToBus")
    private EntityManager em;
	
	@GET
	@Path("notifications/{user_id}")
	public Set<Notification> getNotification(@PathParam("user_id")int id)
	{
		User user = em.find(User.class, id);
		return user.getNotification();
	}

}
