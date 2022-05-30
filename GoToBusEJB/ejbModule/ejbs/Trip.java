package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Date;
//import java.sql.Timestamp;

@Stateless
@LocalBean
@Entity
@Table(name="TRIP")
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_id")
	private int id;
	@Column(name = "from_station")
	private String fromStation;
	@Column(name = "to_station")
	private String toStation;
	@Temporal(TemporalType.DATE)
	@Column(name = "departure_time")
	private Date departureTime;
	@Temporal(TemporalType.DATE)
	@Column(name = "arrival_time")
	private Date arrivalTime;
	@Column(name = "available_seats")
	private int seatsNum;
	
	public Trip()
	{
		super();
	}
	
	public int getSeatsNum() {
		return seatsNum;
	}
	public void setSeatsNum(int seatsNum) {
		this.seatsNum = seatsNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getMsg()
	{
		return "hello";
	}

	
}
