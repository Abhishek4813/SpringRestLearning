package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.pojo.Country;

@RestController
public class CountryController {
	
	public static final  Logger LOGGER= LoggerFactory.getLogger(HelloController.class);
	
	ApplicationContext context;

	@GetMapping("/country")
	public ResponseEntity<Country> getCountryIndia(){
		LOGGER.info("getCountryIndia start");
		
		context= new ClassPathXmlApplicationContext("country.xml");
		Country beanIndia= (Country) context.getBean("in");
		
		LOGGER.info("getCountryIndia End");
		return ResponseEntity.status(HttpStatus.OK).body(beanIndia);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getAllCountries(){
		LOGGER.info("getAllCountries start");
		
		context= new ClassPathXmlApplicationContext("country.xml");
		List<Country> bean= (List<Country>) context.getBean("countryList");
		
		LOGGER.info("getAllContries End");
		return ResponseEntity.status(HttpStatus.OK).body(bean);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/country/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable("code") String code) throws CountryNotFoundException{
		LOGGER.info("getCountryIndia start");
		
		context= new ClassPathXmlApplicationContext("country.xml");
		List<Country> bean= (List<Country>) context.getBean("countryList");
		Country beanCountry=null;
		for(Country ctr:bean) {
			if(ctr.getCode().equalsIgnoreCase(code))
				beanCountry=ctr;
		}
		if(beanCountry==null)
			throw new CountryNotFoundException("Country Not Found");
		
		LOGGER.info("getCountryIndia End");
		return ResponseEntity.status(HttpStatus.OK).body(beanCountry);
	}
}
