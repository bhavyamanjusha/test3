package com.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auction.entity.Seller;


public interface SellerRepository extends JpaRepository<Seller, String>
{
	
}
