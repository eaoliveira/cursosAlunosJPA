package tela3;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Mensagem;
import dao.CursoDao;
import modelo.Aluno;

@SuppressWarnings("serial")
@WebServlet("/incluiAluno")
public class IncluiAluno extends HttpServlet {
	@EJB
	private CursoDao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obtem os dados para salvar
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		Integer idcurso = Integer.parseInt(request.getParameter("curso"));
		
		// salva os dados
		Aluno obj = new Aluno();
		obj.setNome(nome);
		obj.setEmail(email);
		obj.setNomeCurso(dao.getCurso(idcurso));
		dao.adiciona(obj);
		// prepara a mensagem para o usuario
		Mensagem msg = new Mensagem();
		msg.setTitulo("Cadastro de Alunos");
		msg.setTexto("Sucesso na Inclusão");
		msg.setUrl("index.html");
		
		// salva a mensagem
		request.getSession().setAttribute("msg", msg);
		// envia a mensagem
		response.sendRedirect("resultPage.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
