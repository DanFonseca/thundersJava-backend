package com.br.thundersJava.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.br.thundersJava.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia, Integer> {
	public List<Agencia> findBynomeAgencia(String nomeAgencia);	
	
}
