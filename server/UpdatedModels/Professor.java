package projeto.matriculeme.domain;

import javax.persistence.*;

@Entity
public class Professor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length = 150)
	private String nome;// Nome do professor

	public Professor() 
	{
		this.nome = new String();
	}
	public int getId() 
	{
		return id;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getNome() 
	{
		return nome;
	}
}