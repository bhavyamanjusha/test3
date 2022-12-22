package com.auction.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.entity.Customer;
import com.auction.repository.CustomerRepository;
import com.auction.service.ICustomerService;
import com.auction.util.CustomerUtil;


import com.auction.service.impl.*;


@RestController
@RequestMapping("/rest/customer")
@CrossOrigin(origins = "http://localhost:4200")

public class CustomerController {
	private Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerUtil util;
	@Autowired
	private CustomerRepository feed;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(
			@RequestBody Customer customer)
	{
		log.info("customer name=====>"+customer.getCustomer_email()+" Customer name is====>"+customer.getCustomer_name());
		System.out.println("email=====>"+customer.getCustomer_email()+" Name is ====>"+customer.getCustomer_name());
		log.info("Entered into method with Customer data to save");
		ResponseEntity<String> resp = null;
		try {
			log.info("About to call save Operation");
			
			String email = service.saveCustomer(customer);
			log.debug("Customer saved with name" +email);
			
			String body = "Customer "+ email +" ' created";
			
			resp = new ResponseEntity<String>(body, HttpStatus.CREATED);
			log.info("Success response constructed");
		}
		catch (Exception e) {
			log.error("Unable to save Login : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Customer Registration", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		return resp;
	}
	
	
	@GetMapping("/one{id}")
	public ResponseEntity<?> getOneCustomer(
			@PathVariable String id
			) 
	{
		log.info("Entered into Get one Customer method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Customer> opt =  service.getOneCustomer(id);
			if(opt.isPresent()) {
				log.info("Customer exist=>"+id);
				resp = new ResponseEntity<Customer>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Customer id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Customer '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process student fetch", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}
	
	
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateCustomer(
			@PathVariable String id,
			@RequestBody Customer customer
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Customer> opt = service.getOneCustomer(id);
			if(opt.isPresent()) {
				log.info("Customer present in database");
				Customer actual = opt.get();
				util.mapToActualObject(actual,customer);
				service.updateCustomer(actual);
				resp = new ResponseEntity<String>(
						"Customer ' "+ id+ " ' Updated ", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Customer update done successfully");
			} else {
				log.info("Customer does not exist=>"+ id);
				resp = new ResponseEntity<String>(
						"Customer '"+id+"' not found", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.BAD_REQUEST
						);
			}

		} catch (Exception e) {
			log.error("Unable to perform Update Operation=>" + e.getMessage() );
			resp = new ResponseEntity<String>(
					"Unable to process Update",
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	
}

