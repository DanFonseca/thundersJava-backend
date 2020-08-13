package com.br.thundersJava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Agendamento {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora", length = 10)
	private String hora;
	
	@Column(name="observacao", length = 100)
	private String observacao;
	
	@Column(name="nome", length = 50)
	private String nome;
	
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="celular", length = 20)
	private String celular;
	
	@ManyToOne
	@JsonIgnoreProperties("agendamentos")
	private Agencia agencia;

	public Agendamento(int id, Date data, String hora, String observacao, Agencia agencia, String nome, String email,
			String celular) {
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.observacao = observacao;
		this.agencia = agencia;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
	}

	public Agendamento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", data=" + data + ", hora=" + hora + ", observacao=" + observacao
				+ ", agencia=" + agencia + ", nome=" + nome + ", email=" + email + ", celular=" + celular + "]";
	}

	
}
