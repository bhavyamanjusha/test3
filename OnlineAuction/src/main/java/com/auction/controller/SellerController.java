

package com.auction.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.entity.Customer;
import com.auction.entity.Seller;
import com.auction.repository.CustomerRepository;
import com.auction.repository.SellerRepository;
import com.auction.service.ICustomerService;
import com.auction.service.ISellerService;
import com.auction.util.CustomerUtil;
import com.auction.util.SellerUtil;
import com.auction.service.impl.*;


@RestController
@RequestMapping("/rest/seller")
@CrossOrigin(origins = "http://localhost:4200")

public class SellerController {
	private Logger log = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	private ISellerService service;
	@Autowired
	private SellerUtil util;
	@Autowired
	private SellerRepository feed;
	
	
	// To save Seller data in database
	@PostMapping("/save")
	public ResponseEntity<String> saveSeller(
			@RequestBody Seller seller)
	{
		log.info("seller name=====>"+seller.getSeller_email()+" Seller name is====>"+seller.getSeller_name());
		System.out.println("email=====>"+seller.getSeller_email()+" Name is ====>"+seller.getSeller_name());
		log.info("Entered into method with Seller data to save");
		ResponseEntity<String> resp = null;
		try {
			log.info("About to call save Operation");
			
			String email = service.saveSeller(seller);
			log.debug("Seller saved with email" +email);
			
			String body = "Seller "+ email +" ' created";
			
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
	
	
	//To Get Seller by Email
	@GetMapping("/one/{seller_email}")
	public ResponseEntity<?> getOneSeller(
			@PathVariable String seller_email
			) 
	{
		log.info("Entered into Get one Seller method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Seller> opt =  service.getOneSeller(seller_email);
			if(opt.isPresent()) {
				log.info("Seller exist=>"+seller_email);
				resp = new ResponseEntity<Seller>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Seller email not exist=>"+ seller_email);
				resp = new ResponseEntity<String>(
						"Customer '"+ seller_email +"' not exist", 
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
	
	
	//To get Seller By ID
	@GetMapping("/one/{seller_ID}")
	public ResponseEntity<?> getSellerID(
			@PathVariable String seller_ID
			) 
	{
		log.info("Entered into Get one Seller ID method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Seller> opt =  service.getSellerID(seller_ID);
			if(opt.isPresent()) {
				log.info("Seller ID  exist=>"+ seller_ID);
				resp = new ResponseEntity<Seller>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Seller ID not exist=>"+seller_ID);
				resp = new ResponseEntity<String>(
						"Seller '"+ seller_ID +"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process seller ID fetch", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	
	
	//To update seller details by email and product details will also get updated
	@PutMapping("/modify/{seller_email}")
	public ResponseEntity<String> updateSeller(
			@PathVariable String seller_email,
			@RequestBody Seller seller
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Seller> opt = service.getOneSeller(seller_email);
			if(opt.isPresent()) {
				log.info("Seller present in database");
				Seller actual = opt.get();
				util.mapToActualObject(actual,seller);
				service.updateSeller(actual);
				resp = new ResponseEntity<String>(
						" Seller' "+ seller_email+ " ' Updated ", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Seller update done successfully");
			} else {
				log.info("Seller does not exist=>"+ seller_email);
				resp = new ResponseEntity<String>(
						"Seller '"+ seller_email+"' not found", 
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
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllSellers() {
		log.info("Entered into method to fetch Sellers data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch register service");
			List<Seller> list = service.getAllSellers();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				list.sort((s1,s2)->s1.getSeller_email().compareTo(s2.getSeller_email()));
				/* JDK 1.8
				list = list.stream()
						.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
						.collect(Collectors.toList());
				 */
				resp = new ResponseEntity<List<Seller>>(list, HttpStatus.OK);
			} else {
				log.info("No Registrations exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Registrations Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch sellers : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Registrations", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}
	
	
	//To delete seller by email
	@DeleteMapping("/remove/{seller_email}")
	public ResponseEntity<String> removeRegister(
			@PathVariable String seller_email)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isSellerExist(seller_email);
			if(exist) {
				service.deleteSeller(seller_email);
				log.info("Register exist with given email and deleted=>"+ seller_email);
				resp = new ResponseEntity<String>(
						"Register '"+ seller_email +"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given email not exist =>"+ seller_email);
				resp = new ResponseEntity<String>(
						"Register '"+seller_email +"' not exist",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to perform Delete Operation =>" + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to delete", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}
	
	
	

	
}


