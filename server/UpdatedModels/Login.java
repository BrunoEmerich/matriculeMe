package projeto.matriculeme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, length = 40)
	private String password;
	@Column(nullable = false, length = 100,unique = true)
	private String accessKey;

	public Login() 
	{
		this.password = new String();
		this.accessKey = new String();
	}
	public int getId() 
	{
		return id;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public void setAccessKey(String accessKey) 
	{
		this.accessKey = accessKey;
	}
	public String getAccessKey() 
	{
		return accessKey;
	}
}
