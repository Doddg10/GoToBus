package service;

import java.util.List; 

import javax.ejb.EJB;
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
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserService{
	
	@PersistenceContext(unitName= "User")
    private EntityManager em;
	
	
	
	@POST
	@Path("/register")
	public void register(User NewUser) {
		try
		{
			NewUser.setUserName(user.getUserName());
			NewUser.setPassword(user.getPassword());
			NewUser.setFullName(user.getFullName());
			NewUser.setRole(user.getRole());
			em.persist(NewUser);
		}
		catch(Exception e) {
			throw new EJBException(e);
		} 
	}
	
	@EJB
	User user;
	
	@POST
	@Path("login") ///{userName}/{password}
	public boolean login(String userName,String password) {
		try{
			
			Query query=em.createQuery("SELECT u from User u where u.userName LIKE ?1 and u.password LIKE ?2");
			query.setParameter(1, userName);
			query.setParameter(2, password);
			user = (User) query.getResultList();
            if (user != null){
            System.out.println("Logged in Successfuly");
            System.out.print("Hello" + user.getUserName());
            return true;
            } else 
                System.out.print("Wrong cridentials");
            return false;
            }
		catch(Exception e){
        	throw new EJBException(e);
        }
        }
	
	@GET
	@Path("usersList")
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> users = query.getResultList();
		return users;
}
	
	@GET
	@Path("/hello")
	public String sayHello() {
		return user.getMsg();
	}
	
}
