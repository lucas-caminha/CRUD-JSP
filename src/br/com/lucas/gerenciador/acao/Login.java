package br.com.lucas.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.lucas.gerenciador.DAO.UsuarioDAO;
import br.com.lucas.gerenciador.model.Usuario;

public class Login implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("Login: " + login + " | Senha: " + senha);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.existeUsuario(login, senha);
		
		if (usuario != null) {
			System.out.println("Logando... User: " + login);
			// Servidor guarda o usuario no valor da memoria com a Session.
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:central?acao=ListaEmpresas";
		} else {
			System.out.println("Usuario ou senha incorretos.");
			return "redirect:central?acao=LoginForm";
		}
		
	}

}
