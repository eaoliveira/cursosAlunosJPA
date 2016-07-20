package tela;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import dao.CursoDao;
import modelo.Curso;

@ManagedBean
public class CursoBean {
	@EJB
	private CursoDao dao;
	private String nome;
	private String desc;
	private String data;
	private String horas;
	private Integer curso;

	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}


	public List<Curso> getCursos(){
		return dao.getCursos();
	}


	public void salvar(){
		FacesMessage msg;
		try{
			
			Curso obj=new Curso();
			obj.setNome(nome);
			obj.setDescr(desc);
			obj.setHoras(horas);
			obj.setInicio(data);
			dao.adiciona(obj);
			
			nome="";
			desc="";
			horas="";
			data="";
			
			String txt= "Curso Cadastrado";
			msg=new FacesMessage(FacesMessage.SEVERITY_INFO, txt, txt);
		}catch(PersistenceException ex){
			ex.printStackTrace();
			String txt= "Erro ao Cadastrar";
			msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, txt, txt);
			}
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage("form1", msg);
	}

}
