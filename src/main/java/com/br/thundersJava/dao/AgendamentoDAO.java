package com.br.thundersJava.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.br.thundersJava.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
	public List<Agendamento> findByData (Date data);
	public List<Agendamento> findBynomeCliente (String nome);
	public List<Agendamento> findByDataAndAgencia_nomeAgencia(Date data, String nomeAgencia);
	public List<Agendamento> findBynomeClienteAndAgencia_nomeAgencia(String nomeCliente, String nomeAgencia);
	public List<Agendamento> findBynomeClienteAndData(String nomeCliente, Date data);
}
