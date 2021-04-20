package com.tiagoalmeida.comidaboa.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", "Erro de validação !", request.getRequestURI());
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);		
	}
	
	
	@ExceptionHandler(UnexpectedRollbackException.class)
	public ResponseEntity<StandardError> validationTelefone(UnexpectedRollbackException e, HttpServletRequest request) {
		
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Numero invalido", "numero já cadastrado !", request.getRequestURI());
		
		
			error.addError("telefone", "numero já cadastrado");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);		
	}

}
