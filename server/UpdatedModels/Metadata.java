package projeto.matriculeme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Metadata
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length = 255)
	private String json;
	@Column(nullable = false,length = 40)
	private String classe;

	public Metadata() 
	{
		this.json = new String();
		this.classe = new String();
	}
	public int getId() 
	{
		return id;
	}
	public String getJson() 
	{
		return json;
	}
	public void setJson(String json) 
	{
		this.json = json;
	}
	public String getClasse()
	{
		return classe;
	}
	public void setClasse(String classe)
	{
		this.classe = classe;
	}
}
