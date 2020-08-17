package com.br.thundersJava.config;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

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
		
        //criando os gerentes
		Gerente daniel = new Gerente(1,"daniel","0101", "danfreitas", "123", "daniel.jpeg","daniel@daniel.com");
		gerenteDAO.saveAll(Arrays.asList(daniel));
		
		
		//criando cadastro de agencias.
		Agencia mooca = new Agencia(1,"Mooca","09:00","14:00", null);
		Agencia interlagos = new Agencia(2,"Interlagos","09:00","14:00", null);
		Agencia jabaquara = new Agencia(3,"Jabaquara","09:00","14:00", null);
		Agencia morumbi = new Agencia(4,"Morumbi","09:00","14:00", null);
		
		agenciaDAO.saveAll(Arrays.asList(mooca, interlagos, jabaquara, morumbi));

	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);

	    mailSender.setUsername("thunderjava2020@gmail.com");
	    mailSender.setPassword("123qwe2020");

	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");

	    return mailSender;
	}
}