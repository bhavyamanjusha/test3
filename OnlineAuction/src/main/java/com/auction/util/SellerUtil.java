package com.auction.util;

import org.springframework.stereotype.Controller;

import com.auction.entity.Seller;


@Controller
public class SellerUtil {

	public void mapToActualObject(Seller actual, Seller seller) {

		actual.setSeller_email(seller.getSeller_email());
		actual.setSeller_name(seller.getSeller_name());
		actual.setSeller_dob(seller.getSeller_dob());
		actual.setSeller_contact(seller.getSeller_contact());
		actual.setSeller_city(seller.getSeller_city());
		actual.setSeller_prod_category(seller.getSeller_prod_category());
		actual.setSeller_prod_name(seller.getSeller_prod_name());
		actual.setSeller_ID(seller.getSeller_ID());




	}

}
