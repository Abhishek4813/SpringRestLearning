package com.cognizant.springlearn.exception;

public class CountryNotFoundException extends RuntimeException{

	public CountryNotFoundException(String msg){
		super(msg);
	}
}
