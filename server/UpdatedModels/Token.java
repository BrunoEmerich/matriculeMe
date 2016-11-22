package projeto.matriculeme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import projeto.matriculeme.intern.Security;

@Entity
public class Token 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false, length = 32)
	private String token;
	@Column(nullable = false)
	private long time;
	
	public Token() 
	{
		this.time = System.currentTimeMillis();
		this.token = Security.stringToMD5(String.valueOf(this.time));
	}
	public int getId() 
	{
		return id;
	}
	public String getToken() 
	{
		return token;
	}
	public void setToken() 
	{
		this.token = Security.stringToMD5(String.valueOf(this.time));
	}
	public long getTime() 
	{
		return time;
	}
	public void setTime() 
	{
		this.time = System.currentTimeMillis();
	}
}
