package tela;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import modelo.Aluno;
import modelo.Curso;

@WebServlet("/ListaAlunos")
public class ListaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CursoDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obter a lista de cursos
		List<Aluno> lista = dao.getAluno();
		// salvar os cursos na sessao http
		List<Curso> lista2 = dao.getCursos();
		// salvar os cursos na sessao http
		request.getSession().setAttribute("cursos", lista2);
		request.getSession().setAttribute("aluno", lista);
		// redirecionar para o jsp que monta a lista
		response.sendRedirect("listaAluno.jsp");
	}
}
