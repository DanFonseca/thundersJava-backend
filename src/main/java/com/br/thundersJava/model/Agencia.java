package com.br.thundersJava.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Agencia {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length = 50)
	private String nome;
	@Column(name="horaInicio", length = 10)
	private String horaInicio;
	@Column(name="horaFim", length = 10)
	private String horaFim;
	
	 
	@OneToMany(cascade = CascadeType.ALL , mappedBy="agencia")
	@JsonIgnoreProperties("agencia")
	private List<Agendamento> agendamentos;

	
	public Agencia(int id, String nome, String horaInicio, String horaFim) {
		super();
		this.id = id;
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	

	public Agencia() {
		super();
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

	public void setAgendamento(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}


	@Override
	public String toString() {
		return "Agencia [id=" + id + ", nome=" + nome + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim
				+ ", agendamento=" + agendamentos + "]";
	}
	

	
}
