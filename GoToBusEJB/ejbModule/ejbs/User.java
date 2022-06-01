package ejbs;

import java.io.Serializable; 
import java.lang.Integer;
import java.lang.String;
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
	private String userName;   
	private String password;
	private String fullName;
	private String role;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="UserXTrips",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="trip_id"))
	private Set<Trip> trips;
	private static final long serialVersionUID = 1L;

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


	public User() {
		super();
	} 
	
	public User(String userName,String password) {
		this.userName=userName;
		this.password=password;
	}  
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}  
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getFullName() {
		return fullName;
		
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
		
	}
	public String getRole() {
		return role;
		
	}
	
	public void setRole(String role) {
		this.role = role;
		
	}
   
}
