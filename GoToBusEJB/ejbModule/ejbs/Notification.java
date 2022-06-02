package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Stateless
@LocalBean
@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String message;
	private String notification_datetime;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	public void setUser(User user)
	{
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNotification_datetime() {
		return notification_datetime;
	}

	public void setNotification_datetime(String notification_datetime) {
		this.notification_datetime = notification_datetime;
	}

}