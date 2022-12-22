package com.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auction.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String>
{
	
}
