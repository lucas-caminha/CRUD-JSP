package br.com.lucas.gerenciador.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.lucas.gerenciador.model.Empresa;

/**
 * 
 * @author lucas.caminha
 * @version 0.1
 *
 * Esta classe é um Data access object da classe Empresa utilizando ArrayList.
 */

public class EmpresaDAO {
	
	private static List<Empresa> listaDeEmpresas = new ArrayList<>();
	
	// Adiciona uma empresa a lista de empresas.
	public void adiciona(Empresa empresa) {
		listaDeEmpresas.add(empresa);
	}
	
	// Remove uma empresa com o nome pelo parametro.
	public void remove(String nomeEmpresa) {
		for (Empresa empresa : listaDeEmpresas) {
			if(nomeEmpresa.equals(empresa.getNome())) {
				System.out.println("Empresa Removida: " + empresa.toString());
				listaDeEmpresas.remove(empresa);
			}
		}
	}
	
	// Remove uma empresa com o id pelo parametro.
	public void remove(int id) {
		for (Empresa empresa : listaDeEmpresas) {
			if(id == empresa.getId()) {
				System.out.println("Empresa Removida: " + empresa.toString());
				listaDeEmpresas.remove(empresa);
			}
		}
	}
	
	// Edita a empresa.
	public void edita(String nome, Date data, Empresa empresa) {
		empresa.setNome(nome);
		empresa.setDataAbertura(data);
	}
	
	public Empresa buscaEmpresa(int id) {
		for (Empresa empresa : listaDeEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	// Retorna a listaDeEmpresas imodificavel
	public List<Empresa> getListaDeEmpresas(){
		return Collections.unmodifiableList(listaDeEmpresas);
	}

}
