package tela;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import dao.CursoDao;
import modelo.Aluno;

@ManagedBean
public class AlunoBean {
	@EJB
	private CursoDao dao;
	private String nome;
	private String email;
	private Integer cursoId;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCursoId() {
		return cursoId;
	}
	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}
	public void salvar(){
		FacesMessage msg;
		
		try{
			Aluno obj=new Aluno();
			obj.setNome(nome);
			obj.setEmail(email);
			obj.setNomeCurso(dao.getCurso(cursoId));
			dao.adiciona(obj);
			
			nome="";
			email="";
			String txt= "Aluno Cadastrado";
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
