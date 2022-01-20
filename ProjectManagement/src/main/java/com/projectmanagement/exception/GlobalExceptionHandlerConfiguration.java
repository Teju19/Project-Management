package com.projectmanagement.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice
public class GlobalExceptionHandlerConfiguration {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleException(MethodArgumentNotValidException ex) {
		List<FieldError> errors = ex.getFieldErrors();
		ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
		for (FieldError err : errors) {
			validationErrorResponse.getErrors().put(err.getField(), err.getDefaultMessage());
			validationErrorResponse.setMessage(err.getDefaultMessage());
		}
		validationErrorResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
	
		
		validationErrorResponse.setTime(LocalDateTime.now());
		return new ResponseEntity<ValidationErrorResponse>(validationErrorResponse, HttpStatus.BAD_REQUEST);
	}

	

	@ExceptionHandler(MyCustomizeedException.class)
	public ResponseEntity<ErrorMessage> handleException(MyCustomizeedException ex) {
		ErrorMessage errorResponse = new ErrorMessage();
		errorResponse.setTime(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setResponseCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorMessage>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
