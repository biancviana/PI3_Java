package com.lebi.model;

import com.lebi.dao.UsuarioDao;

public class Paciente extends Usuario{
	private String cpf;

	
	public Paciente(String nome, String email) {
		super(nome, email);
	}
	
	public Paciente(String nome, String cpf, String telefone, String endereco, String senha, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.senha = senha;
		this.email = email;

	}
		
	public String getCpf() {return cpf;}
	public void setCpf(String cpf) {this.cpf = cpf;}
		
	public boolean cadastro() {
		UsuarioDao ud = new UsuarioDao();
		Boolean paciente = ud.cadastrar(nome, cpf, telefone, endereco, senha, email);
		
		if(paciente) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
