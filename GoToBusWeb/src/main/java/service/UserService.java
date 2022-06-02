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

	@Path("login") ///{userName}/{password}

	public String login(User user) {

		try{

			String username=user.getUsername();

			String password=user.getPassword();

//			em.detach(user);

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

	

	@GET

	@Path("usersList")

	public List<User> getAllUsers() {

		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ", User.class);

		List<User> users = query.getResultList();

		return users;

}

	

}