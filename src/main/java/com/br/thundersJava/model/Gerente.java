package com.br.thundersJava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GERENTE")
public class Gerente {
	
	@Column(name="id")
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length=40)
	private String nome;
	
	@Column(name="funcional", length=15)
	private String funcional;
	
	@Column(name="racf", length=10)
	private String racf;
	
	@Column(name="senha", length=20)
	private String senha;
	
	@Column(name="foto", length=100)
	private String foto;
	
	@Column(name="email", length=70)
	private String email;
	
	public Gerente() {
		super();
	}
	
	public Gerente(int id, String nome, String funcional, String racf, String senha, String foto, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcional = funcional;
		this.racf = racf;
		this.senha = senha;
		this.foto = foto;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncional() {
		return funcional;
	}

	public void setFuncional(String funcional) {
		this.funcional = funcional;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Gerente [id=" + id + ", nome=" + nome + ", funcional=" + funcional + ", racf=" + racf + ", senha="
				+ senha + ", foto=" + foto + "EMAIL=" + email + "]";
	}
	
	
}
