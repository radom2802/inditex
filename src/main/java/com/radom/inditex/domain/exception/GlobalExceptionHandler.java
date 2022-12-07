package com.radom.inditex.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(value = { BadRequestException.class })
	ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = { PriceNotFoundException.class })
	ResponseEntity<ErrorResponse> handlePriceNotFoundException(PriceNotFoundException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(value = { Exception.class })
	ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
