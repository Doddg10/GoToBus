package ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Stateless
@LocalBean
@Table(name="STATION")
public class Station implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="latitude")
	private String latitude;
	@Column(name="longitude")
	private String longitude;
	private int from_station;
	private int to_station;
	private static final long serialVersionUID = 1L;

	public Station() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}   
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public int getFrom_station() {
		return from_station;
	}
	public void setFrom_station(int from_station) {
		this.from_station = from_station;
	}
	public int getTo_station() {
		return to_station;
	}
	public void setTo_station(int to_station) {
		this.to_station = to_station;
	}

}