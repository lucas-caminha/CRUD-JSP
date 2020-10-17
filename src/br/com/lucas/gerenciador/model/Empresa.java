package br.com.lucas.gerenciador.model;

import java.util.Date;

/**
 * 
 * @author lucas.caminha
 * @version 0.1
 * Esta classe representa uma empresa.
 */

public class Empresa {
	
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public Empresa(Integer id, String nomeEmpresa) {
		this.id = id;
		this.nome = nomeEmpresa;
	}
	
	public Empresa(Integer id, String nome, Date dataAbertura) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
			

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		
		return "Empresa: {Id: " + this.id + "|Nome: " + this.nome + "|Data: " + this.dataAbertura.toString(); 
	}

	
	
	

}
