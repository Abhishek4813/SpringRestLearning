package com.cognizant.springlearn.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.exception.ErrorPojo;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler
	public ResponseEntity<ErrorPojo> handelCountryNotFound(CountryNotFoundException e, HttpServletRequest request){
		ErrorPojo err= new ErrorPojo();
		err.setTimestamp(new Date().toString());
		err.setMessage(e.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
