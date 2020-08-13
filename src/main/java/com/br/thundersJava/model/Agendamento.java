package com.br.thundersJava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itmn032_agendamento")
public class Agendamento {
	
	@Column(name="id")
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_cli", length=100)
	private String nome_cli;

	@Column(name="email_cli", length = 100)
	private String email_cli;
	
	@Column(name="celular_cli", length = 20)
	private String celular_cli;
		
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="hora", length=5)
	private String  hora;
	
	@Column(name="observacao", length = 255)
	private String observacao;
			
	@ManyToOne
	@JsonIgnoreProperties("agendamentos")
	private Agencia agencia;
	
	
	public Agendamento() {
		super();
	}

	
public Agendamento(int id, String nome_cli, String email_cli, String celular_cli, Date data, String hora,
			String observacao, Agencia agencia) {
		super();
		this.id = id;
		this.nome_cli = nome_cli;
		this.email_cli = email_cli;
		this.celular_cli = celular_cli;
		this.data = data;
		this.hora = hora;
		this.observacao = observacao;
		this.agencia = agencia;
	}




public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome_cli() {
		return nome_cli;
	}


	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}


	public String getEmail_cli() {
		return email_cli;
	}


	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}


	public String getCelular_cli() {
		return celular_cli;
	}


	public void setCelular_cli(String celular_cli) {
		this.celular_cli = celular_cli;
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


	
	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", data=" + data + ", hora=" + hora + ", observacao=" + observacao
				+ ", agencia=" + agencia + ", nome=" + nome_cli + ", email=" + email_cli + ", celular=" + celular_cli + "]";
	}

	
}
