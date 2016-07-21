package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Aluno {
	@Id
	@Column(name="idaluno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private String email;
	@ManyToOne //(fetch=FetchType.EAGER)
	@JoinColumn(name="idcurso")
	private Curso nomeCurso;
	@Transient
	private boolean del=false;

	public Integer getId() {
		return Id;
	}

	public Aluno setId(Integer id) {
		Id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Aluno setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Curso getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(Curso nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

		public String getEmail() {
		return email;
	}

	public Aluno setEmail(String descr) {
		this.email = descr;
		return this;
	}

	@Override
	public String toString() {
		return "Id: " + Id + " nome: " + nome + " descr: " + email;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}
	

}
