package com.example.webstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.webstore.entity.Customer;
import com.example.webstore.repository.CustomerRepository;

@SpringBootApplication
public class WebstoreApplication {

	  private static final Logger log = LoggerFactory.getLogger(WebstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner testMethod(CustomerRepository customerRepository){
		return args -> {
			Customer tester = new Customer("Bilbo", "Baggins");
			log.info("Preloading " + customerRepository.save(tester));
			log.info(tester.getId().toString());
			log.info("Preloading " + customerRepository.save(new Customer("Frodo", "Baggins")));
		  };
	}

}
