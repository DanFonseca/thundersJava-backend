package com.br.thundersJava.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.thundersJava.dao.AgenciaDAO;
import com.br.thundersJava.dao.AgendamentoDAO;
import com.br.thundersJava.dao.GerenteDAO;
import com.br.thundersJava.model.Agencia;
import com.br.thundersJava.model.Gerente;

@Configuration
public class configs implements CommandLineRunner  {
	
	@Autowired
	private GerenteDAO gerenteDAO;
	
	@Autowired
	private AgenciaDAO agenciaDAO;
	
	@Autowired
	private AgendamentoDAO agendamentoDAO;

	@Override
	public void run(String... args) throws Exception {		
//		agenciaDAO.deleteAll();
//		gerenteDAO.deleteAll();
//		agendamentoDAO.deleteAll();
		
        //criando os gerentes
		Gerente daniel = new Gerente(1,"daniel","987312845", "dafrefo", "123", "daniel.jpeg","daniel@daniel.com");
		Gerente adriana = new Gerente(2,"adriana","912365785", "asgasdc", "456", "adriana.jpeg", "adriana@adriana.com");
		gerenteDAO.saveAll(Arrays.asList(daniel, adriana));
		
		
		//criando cadastro de agencias.
		Agencia mooca = new Agencia(1,"Mooca","09:00","14:00", null);
		Agencia interlagos = new Agencia(2,"Interlagos","09:00","14:00", null);
		Agencia jabaquara = new Agencia(3,"Jabaquara","09:00","14:00", null);
		Agencia morumbi = new Agencia(4,"Morumbi","09:00","14:00", null);
		
		agenciaDAO.saveAll(Arrays.asList(mooca, interlagos, jabaquara, morumbi));

	}
}