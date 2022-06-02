package ejbs;

import java.io.Serializable; 
import java.lang.Integer;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: User
 *
 */

@Stateless
@LocalBean
@Entity
@Table(name="User")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id")
	private int user_id;
	private String username;   
	private String password;
	private String full_name;
	private String role;
	private boolean loggedIn = false;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="UserXTrips",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="trip_id"))
	private Set<Trip> trips;
	private static final long serialVersionUID = 1L;
	
	public User() {
		super();
		trips = new HashSet<>();
	} 
	
	public void addTrip(Trip trip)
	{
		trips.add(trip);
	}
	
	
	public Set<Trip> getTrips() {
		return trips;
	}

	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}  
	
 
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}


	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	

	public String getRole() {
		return role;
		
	}
	
	public void setRole(String role) {
		this.role = role;
		
	}
	public void Login()
	{
		this.loggedIn = true;
	}
	
	public boolean checkLog()
	{
		return loggedIn;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}
}
