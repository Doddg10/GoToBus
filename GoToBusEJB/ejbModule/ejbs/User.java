package ejbs;

import java.io.Serializable; 
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: User
 *
 */

@Entity

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;   
	private String password;
	private String fullName;
	private String role;
	private static final long serialVersionUID = 1L;

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
	
	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
