package com.br.thundersJava.dao;

import org.springframework.data.repository.CrudRepository;import com.br.thundersJava.model.Gerente;

public interface GerenteDAO extends CrudRepository<Gerente, Integer> {
	
	public Gerente findByFuncionalAndSenha(String funcional, String senha);
	public Gerente findByRacfAndSenha(String racf, String senha);
	public Gerente findByEmailAndSenha(String email, String senha);

}
