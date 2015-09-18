package org.paulojr.springmvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

	private Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(Exception.class)
	public String tratadorDeException(Exception e) {
		log.error("Erro genérico captado", e);
		return "tratei";
	}
	
}
