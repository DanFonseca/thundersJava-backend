package com.br.thundersJava.dao;

import org.springframework.data.repository.CrudRepository;

import com.br.thundersJava.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {

}
