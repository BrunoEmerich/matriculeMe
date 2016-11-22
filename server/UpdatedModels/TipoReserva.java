package projeto.matriculeme.domain;

import javax.persistence.*;

@Entity
public class TipoReserva
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private int tipo;
	@Column(nullable = false)
	private int valor;

	public TipoReserva() 
	{
		this.tipo = 0;
		this.valor = 0;
	}
	public int getId() 
	{
		return id;
	}
	public int getTipo() 
	{
		return tipo;
	}
	public void setTipo(int tipo) 
	{
		this.tipo = tipo;
	}
	public int getValor() 
	{
		return valor;
	}
	public void setValor(int valor) 
	{
		this.valor = valor;
	}
}
