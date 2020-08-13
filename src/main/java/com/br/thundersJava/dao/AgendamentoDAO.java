package com.br.thundersJava.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.br.thundersJava.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
	public List<Agendamento> findByData (Date data);
	//public List<Agendamento> findBynome_cli (String nome);
}
