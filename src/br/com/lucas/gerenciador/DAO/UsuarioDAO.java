package br.com.lucas.gerenciador.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.model.Usuario;

public class UsuarioDAO {
	
	private static List<Usuario> usuarios = new ArrayList<>();
	
	public UsuarioDAO() {
		// Isso aqui é um teste
		adiciona(new Usuario("lucas", "senha"));
		adiciona(new Usuario("teste", "teste123"));
	}
	
	// Adiciona usuario
	public void adiciona(Usuario usuario) {
		usuarios.add(usuario);
	}
	

	


}
