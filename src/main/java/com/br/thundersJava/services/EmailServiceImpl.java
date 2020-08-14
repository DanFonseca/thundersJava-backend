package com.br.thundersJava.services;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.br.thundersJava.model.Agendamento;

@Component
public class EmailServiceImpl {
	
	   @Autowired
	    private JavaMailSender emailSender;

	    public void sendSimpleMessage(Agendamento agendamento) {
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    	
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("thunderjava2020@gmail.com");
	        message.setTo(agendamento.getEmailCliente()); 
	        message.setSubject("Cadastro Realizado com Sucessp!"); 
	        message.setText("Prezado " + agendamento.getNomeCliente() + ", Informamos que seu agendamento foi cadastrado com sucesso! Para o dia " + sdf.format(agendamento.getData()) + " as " + agendamento.getHora());
	        emailSender.send(message);
	    }

}
