package com.cognizant.springlearn.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Country.class);

	private String code;
	private String name;
	
	public Country() {
		super();
		LOGGER.debug("Inside Country Constructor");	
	}
	
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		LOGGER.debug("get Country Code");	
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Set Country Code");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("get Country Name");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Set Country Name");
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
