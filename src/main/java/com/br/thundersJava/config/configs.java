package com.br.thundersJava.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.thundersJava.dao.GerenteDAO;
import com.br.thundersJava.model.Gerente;

@Configuration
public class configs implements CommandLineRunner  {
	
	@Autowired
	private GerenteDAO gerenteDAO;

	@Override
	public void run(String... args) throws Exception {	
		
		gerenteDAO.deleteAll();
		
        
		Gerente daniel = new Gerente(0,"daniel","987312845", "dafrefo", "123", "daniel.jpeg");
		Gerente adriana = new Gerente(0,"adriana","912365785", "asgasdc", "456", "adriana.jpeg");
		
		gerenteDAO.saveAll(Arrays.asList(daniel, adriana));
		

	}
}