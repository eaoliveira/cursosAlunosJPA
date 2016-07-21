package tela;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.persistence.PersistenceException;

import dao.CursoDao;
import modelo.Aluno;
import modelo.Curso;

@ManagedBean
public class AlunoBean {
	@EJB
	private CursoDao dao;
	private String nome;
	private String email;
	private Integer cursoId;
	private ListDataModel<Aluno> alunos;
	private boolean desativado=false;


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
	@SuppressWarnings("unchecked")
	public ListDataModel<Aluno> getAlunos(){
		alunos= new ListDataModel<>(dao.getAluno());
		return alunos;
	}
	
	@SuppressWarnings("unchecked")
	public void remove(){
		for(Aluno item: (List<Aluno>) alunos.getWrappedData()){
			if(item.isDel()){
				dao.removeAluno(item.getId());
			}
		}
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
