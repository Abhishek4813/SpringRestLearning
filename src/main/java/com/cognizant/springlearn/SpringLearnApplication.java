package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.pojo.Country;

@SpringBootApplication
public class SpringLearnApplication {
	
	//get logger object
	private static final Logger LOGGER=LoggerFactory.getLogger(SpringLearnApplication.class);
	private static ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		displayCountry();
	}
	
	public static void displayDate() {
		LOGGER.info("Start");
		context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format=(SimpleDateFormat) context.getBean("dateFormat");
		String date=format.format(new java.util.Date());
		LOGGER.debug(date);
		LOGGER.info("End");
	}
	
	
	@SuppressWarnings("unchecked")
	public static void displayCountry() {
		LOGGER.info("Start");
		context= new ClassPathXmlApplicationContext("country.xml");
		List<Country> country = (List<Country>) context.getBean("countryList");
		
		for(Country ctr:country) {
		LOGGER.debug("Country : {}"+ ctr.toString());
		}
		LOGGER.info("End");
	}

}
