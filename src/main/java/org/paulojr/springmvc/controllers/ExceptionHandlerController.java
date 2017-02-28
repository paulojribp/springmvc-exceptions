package org.paulojr.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	@Autowired
	private MailSender mailSender;
	
	@ExceptionHandler(Exception.class)
	public String tratadorDeException(Exception e, HttpServletRequest request) {
		EmailExceptionHandler emailExceptionHandler = new EmailExceptionHandler(e, request.getRequestURI());
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("paulojribp@gmail.com");
		message.setSubject("[SIGLA SISTEMA] Exception capturada");
		message.setFrom("naoresponda@sistema.com");
		message.setText(emailExceptionHandler.getBody());
		
		mailSender.send(message);
		
		return "tratei";
	}
	
}
