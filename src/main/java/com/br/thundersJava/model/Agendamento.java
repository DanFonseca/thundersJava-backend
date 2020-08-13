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
@Table(name = "AGENDAMENTO")
public class Agendamento {
	
	@Column(name="id")
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nomeCliente", length=100)
	private String nomeCliente;

	@Column(name="emailCliente", length = 100)
	private String emailCliente;
	
	@Column(name="celularCliente", length = 20)
	private String celularCliente;
		
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
	
	
	
	public Agendamento(int id, String nomeCliente, String emailCliente, String celularCliente, Date data, String hora,
			String observacao, Agencia agencia) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.celularCliente = celularCliente;
		this.data = data;
		this.hora = hora;
		this.observacao = observacao;
		this.agencia = agencia;
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


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getCelularCliente() {
		return celularCliente;
	}


	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
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
		return "Agendamento [id=" + id + ", nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente
				+ ", celularCliente=" + celularCliente + ", data=" + data + ", hora=" + hora + ", observacao="
				+ observacao + ", agencia=" + agencia + "]";
	}

	
}
