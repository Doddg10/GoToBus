package service;



import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import ejbs.User;


@Stateless
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserService{
	
	@PersistenceContext(unitName="hello")
    private EntityManager em;
	
	
	
	@POST
	@Path("user")
	public boolean register(User user) {
		try
		{	
			em.persist(user);
			return true;
		}
		catch(Exception e) {
			throw new EJBException(e);
		} 
	}
	
	
	
	@POST
	@Path("login")
	public String login(User user) {
		try{
			String username=user.getUsername();
			String password=user.getPassword();
			Query query=em.createQuery
					("SELECT u from User u WHERE u.username = :username and u.password = :password", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			User loggedInUser =(User) query.getSingleResult();
			
            if (loggedInUser != null){
            	loggedInUser.Login();
            	TripService s = new TripService();
            	s.currentUser = loggedInUser;
            	em.merge(loggedInUser);
            	return "Logged in Successfully";
            } else 
            	return "Wrong cridentials";
            }
		catch(Exception e){
        	throw new EJBException(e);
        }
        }
	
}