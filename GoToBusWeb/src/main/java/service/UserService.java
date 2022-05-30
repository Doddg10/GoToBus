package service;



import java.util.List; 
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	@Path("register")
	public void register(User user) {
		try
		{
			user.getUserName();
			user.getPassword();
			user.getFullName();
			user.getRole();
			em.persist(user);
		}
		catch(Exception e) {
			throw new EJBException(e);
		} 
	}
	
	
	
	@POST
	@Path("login") ///{userName}/{password}
	public String login(User user) {
		try{
			String userName=user.getUserName();
			String password=user.getPassword();
			Query query=em.createQuery
					("SELECT u from User u WHERE u.userName = :userName and u.password = :password", User.class);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			
			User loggedInUser =(User) query.getSingleResult();
			
            if (loggedInUser != null){
            return "Logged in Successfully";
            } else 
            return "Wrong cridentials";
            }
		catch(Exception e){
        	throw new EJBException(e);
        }
        }
	
	@GET
	@Path("usersList")
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ", User.class);
		List<User> users = query.getResultList();
		return users;
}
	
}