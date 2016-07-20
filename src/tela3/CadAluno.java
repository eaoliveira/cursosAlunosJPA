package tela3;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import modelo.Curso;

@WebServlet("/CadAluno")
public class CadAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CursoDao dao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// obter a lista de cursos
		List<Curso> lista = dao.getCursos();
		// salvar os cursos na sessao http
		request.getSession().setAttribute("cursos", lista);
		// redirecionar para o jsp que monta a lista
		response.sendRedirect("cadAluno.jsp");
	}
}
