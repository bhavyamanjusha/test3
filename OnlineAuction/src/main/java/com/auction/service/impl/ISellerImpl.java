
	package com.auction.service.impl;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
import com.auction.entity.Seller;
import com.auction.repository.SellerRepository;
import com.auction.service.ISellerService;

	@Service
	public  class ISellerImpl implements ISellerService 
		
		{

			@Autowired
			private SellerRepository repo;
			
			
			@Override
			public String saveSeller(Seller s) 
			{
				s = repo.save(s);
				return s.getSeller_email();
			}
			
			@Override
			public Optional<Seller> getOneSeller(String seller_email) {
				return repo.findById(seller_email);
			}
			
			@Override
			public boolean isSellerExist(String seller_email) {
				return repo.existsById(seller_email);
			}
		
			@Override
			public void updateSeller(Seller s) {
				repo.save(s);
			}

			@Override
			public Optional<Seller> getSellerID(String seller_ID) {
				return repo.findById(seller_ID);
			}

			@Override
			public  List<Seller> getAllSellers() {
				return repo.findAll();
			}

			@Override
			public void deleteSeller(String seller_email) {
				repo.deleteById(seller_email);
				
			}

			
			


}
