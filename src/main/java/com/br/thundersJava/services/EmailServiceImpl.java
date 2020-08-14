package com.br.thundersJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
	    @Autowired
	    private JavaMailSender emailSender;
	 
	    public void sendSimpleMessage(
	      String to, String subject, String text) {
	      
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("thunderjava2020@gmail.com");
	        message.setTo("daniel.freitas.ms1@gmail.com"); 
	        message.setSubject("teste"); 
	        message.setText("teste");
	        emailSender.send(message);
	    }
}
