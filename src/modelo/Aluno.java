package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	@Id
	@Column(name="idaluno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private String email;
	private Integer idcurso;

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
	
	public Integer getIdcurso() {
		return idcurso;
	}
	
	public Aluno setidCurso(Integer id2) {
		this.idcurso=id2;
		return this;
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

}
