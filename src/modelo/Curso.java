package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Curso {
	@Id
	@Column(name="idcurso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private String descricao;
	private String inicio;
	private String horas;
	@Transient
	private boolean del=false;
	
	public Integer getId() {
		return Id;
	}

	public Curso setId(Integer id) {
		Id = id;
		return this;
	}
	public String getHoras() {
		return horas;
	}

	public Curso setHoras(String horas2) {
		horas = horas2;
		return this;
	}
	
	public String getInicio() {
		return inicio;
	}

	public Curso setInicio(String inicio2) {
		inicio = inicio2;
		return this;
	}
	
	
	public String getNome() {
		return nome;
	}

	public Curso setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getDescr() {
		return descricao;
	}

	public Curso setDescr(String descr) {
		this.descricao = descr;
		return this;
	}

	@Override
	public String toString() {
		return "Id: " + Id + " nome: " + nome + " descr: " + descricao;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}
	
	

}
