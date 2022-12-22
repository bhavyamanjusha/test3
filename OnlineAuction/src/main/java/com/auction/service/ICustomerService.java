package com.auction.service;

import java.util.List;
import java.util.Optional;

import com.auction.entity.Customer;




public interface ICustomerService {
		String saveCustomer(Customer c);
		Optional<Customer>getOneCustomer(String id);
		void updateCustomer(Customer c);
		
	}



