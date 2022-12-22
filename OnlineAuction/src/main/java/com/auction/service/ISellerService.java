package com.auction.service;

import java.util.List;
import java.util.Optional;

import com.auction.entity.Seller;




public interface ISellerService {
		String saveSeller(Seller s);
		Optional<Seller>getOneSeller(String seller_email);
		void updateSeller(Seller s);
		Optional<Seller> getSellerID(String seller_ID);
		List<Seller> getAllSellers();
		boolean isSellerExist(String seller_email);
		void deleteSeller(String seller_email);

		
	}



