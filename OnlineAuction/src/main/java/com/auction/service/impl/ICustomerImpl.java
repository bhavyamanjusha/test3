package com.auction.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.entity.Customer;
import com.auction.repository.CustomerRepository;
import com.auction.service.ICustomerService;

@Service
public  class ICustomerImpl implements ICustomerService 
	
	{

		@Autowired
		private CustomerRepository repo;
		
		@Override
		public String saveCustomer(Customer c) 
		{
			c = repo.save(c);
			return c.getCustomer_email();
		}
		
		@Override
		public Optional<Customer> getOneCustomer(String id) {
			return repo.findById(id);
		}
	
		@Override
		public void updateCustomer(Customer c) {
			repo.save(c);
		}
		


}
