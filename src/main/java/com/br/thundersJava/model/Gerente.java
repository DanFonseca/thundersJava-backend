package com.br.thundersJava.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gerente")
public class Gerente {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String nome;
	@Column(length = 15)
	private String funcional;
	@Column(length = 10)
	private String racf;
	@Column(length = 20)
	private String senha;
	@Column(length = 50)
	private String foto;
	
	
	public Gerente(int id, String nome, String funcional, String racf, String senha, String foto) {	
		this.id = id;
		this.nome = nome;
		this.funcional = funcional;
		this.racf = racf;
		this.senha = senha;
		this.foto = foto;
	}
	
	public Gerente() {}
	
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
	@Override
	public String toString() {
		return "Gerente [id=" + id + ", nome=" + nome + ", funcional=" + funcional + ", racf=" + racf + ", senha="
				+ senha + ", foto=" + foto + "]";
	}
	
	
}
