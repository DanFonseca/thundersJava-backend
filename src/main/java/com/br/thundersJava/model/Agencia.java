package com.br.thundersJava.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itmn032_agencia")
public class Agencia {
	
	@Column(name="id")
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nomeAgencia", length=100)
	private String nomeAgencia;
	
	@Column(name="horaInicio", length = 5)
	private String horaInicio;
	
	@Column(name="horaFim", length = 5)
	private String horaFim;
		 
	@JsonIgnoreProperties("agencia")
	@OneToMany(cascade = CascadeType.ALL , mappedBy="agencia")
	private List<Agendamento> agendamentos;

	
	public Agencia() {
		super();
	}

	
	public Agencia(int id, String nomeAgencia, String horaInicio, String horaFim, List<Agendamento> agendamentos) {
		super();
		this.id = id;
		this.nomeAgencia = nomeAgencia;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.agendamentos = agendamentos;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getNomeAgencia() {
		return nomeAgencia;
	}


	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}


	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", nome=" + nomeAgencia + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim
				+ ", agendamento=" + agendamentos + "]";
	}
	

	
}
