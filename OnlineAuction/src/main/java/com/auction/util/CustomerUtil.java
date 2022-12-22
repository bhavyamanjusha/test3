package com.auction.util;

import org.springframework.stereotype.Controller;

import com.auction.entity.Customer;


@Controller
public class CustomerUtil {

	public void mapToActualObject(Customer actual, Customer customer) {

		actual.setCustomer_email(customer.getCustomer_email());
		actual.setCustomer_name(customer.getCustomer_name());
		actual.setCustomer_dob(customer.getCustomer_dob());
		actual.setCustomer_contact(customer.getCustomer_contact());
		actual.setCustomer_city(customer.getCustomer_city());
		actual.setCust_prod_category(customer.getCust_prod_category());
		actual.setCust_prod_name(customer.getCust_prod_name());
		actual.setCust_ID(customer.getCust_ID());




	}

}
