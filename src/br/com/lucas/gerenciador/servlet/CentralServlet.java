package br.com.lucas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.DAO.UsuarioDAO;
import br.com.lucas.gerenciador.acao.Acao;

/**
 * Servlet implementation class CentralServlet
 */
@WebServlet("/central")
public class CentralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.lucas.gerenciador.acao." + parametro;
		
		String redirecionamento;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			redirecionamento = acao.executa(request,response);
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		//EmpresaDAO empresaDao = new EmpresaDAO();
		//UsuarioDAO usuarioDao = new UsuarioDAO();
		//String redirecionamento = null;
		
		/*
		 * if(parametro.equals("listaEmpresas")) { redirecionamento =
		 * empresaDao.listaEmpresas(request, response); } else if
		 * (parametro.equals("removeEmpresa")) { redirecionamento =
		 * empresaDao.removeEmpresa(request, response); } else if
		 * (parametro.equals("mostraEmpresa")) { redirecionamento =
		 * empresaDao.mostraEmpresa(request, response); } else if
		 * (parametro.equals("alteraEmpresa")) { redirecionamento =
		 * empresaDao.alteraEmpresa(request, response); } else if
		 * (parametro.equals("novaEmpresa")) { redirecionamento =
		 * empresaDao.adicionaEmpresa(request, response); } else if
		 * (parametro.equals("novaEmpresaForm")) { redirecionamento =
		 * empresaDao.novaEmpresaForm(request, response); } else
		 * if(parametro.equals("loginForm")) { redirecionamento =
		 * usuarioDao.loginForm(request, response); } else if(parametro.equals("login"))
		 * { redirecionamento = usuarioDao.login(request, response); } else {
		 * 
		 * redirecionamento = empresaDao.listaEmpresas(request, response); }
		 */
		
		String[] tipoRedirecionamento = redirecionamento.split(":");
		if(tipoRedirecionamento[0].equals("forward")) {
		    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoRedirecionamento[1]);
		    rd.forward(request, response);
		} else {
			response.sendRedirect(tipoRedirecionamento[1]);
		}
		

	}

}
