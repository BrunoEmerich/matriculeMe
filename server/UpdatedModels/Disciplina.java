package projeto.matriculeme.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Disciplina 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false,length = 120)
	private String nome;
	@ManyToOne(cascade ={CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn
	private Departamento departamento;
	@Column(nullable = false)
	private int credito;
	@Column(nullable = false)
	private int codigo;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name = "requisito_disciplina")
	private List<Requisito> requisitoDisciplina;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name = "requisito_disciplina")
	private List<Turma> turmas;

	public Disciplina() 
	{
		this.nome = new String();
		this.departamento = new Departamento();
		this.credito = 0;
		this.codigo = 0;
		this.requisitoDisciplina = new ArrayList<Requisito>();
		this.turmas = new ArrayList<Turma>();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public Departamento getDepartamento()
	{
		return departamento;
	}
	public void setDepartamento(Departamento departamento)
	{
		this.departamento = departamento;
	}
	public int getCredito()
	{
		return credito;
	}
	public void setCredito(int credito)
	{
		this.credito = credito;
	}
	public int getCodigo()
	{
		return codigo;
	}
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	public List<Requisito> getRequisitoDisciplina()
	{
		return requisitoDisciplina;
	}
	public void setRequisitoDisciplina(List<Requisito> requisitoDisciplina)
	{
		this.requisitoDisciplina = requisitoDisciplina;
	}
	public List<Turma> getTurmas()
	{
		return turmas;
	}
	public void setTurmas(List<Turma> turmas)
	{
		this.turmas = turmas;
	}
}