package org.paulojr.springmvc.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailExceptionHandler {

	private Exception exception;
	private String url;

	public EmailExceptionHandler(Exception exception, String url) {
		this.exception = exception;
		this.url = url;
	}
	
	public String getBody() {
		String algumaFormaMagicaDePegarOUsuarioLogado = "João";
		
		StringBuilder builder = new StringBuilder();
		builder.append("URL: " + url + "\n");
		builder.append("Usuário: " + algumaFormaMagicaDePegarOUsuarioLogado + "\n");
		builder.append("Permissão: ROLE_USUARIO \n");
		builder.append("Data Hora: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+ "\n");
		builder.append("Exception MSG: " + exception.getMessage());
		
		return builder.toString();
	}
	
}
