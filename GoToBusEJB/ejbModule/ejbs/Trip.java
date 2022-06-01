package ejbs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.LocalBean; 
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Stateless
@LocalBean
@Entity
@Table(name="Trip")
public class Trip implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "trip_id")
	private int trip_id;
	private String from_station; //cairo
 	private String to_station;	//Aswan
	private int available_seats;
	private String departure_time;
	private String arrival_time;
	private String from_date;
	private String to_date;
	@Transient
	private int user_id;

	@ManyToMany(mappedBy = "trips", fetch = FetchType.EAGER)
	private Set<User> users;
//	@Transient
//	private List<User> allUsers;
	private static final long serialVersionUID = 1L;
	
	public Trip()
	{
		users = new HashSet<>();
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}
	
	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public String getFrom_station() {
		return from_station;
	}
	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}
	public String getTo_station() {
		return to_station;
	}
	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	@Transient
	public int retUserId() {
		return user_id;
	}
	@Transient
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}

