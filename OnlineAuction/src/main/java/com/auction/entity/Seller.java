package com.auction.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Seller {
	
	@Id
	private String seller_email;
	private String seller_name;
	private String seller_dob;
	private String seller_contact;
	private String seller_city;
	private String seller_prod_category;
	private String seller_prod_name;
	private String seller_ID;
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_dob() {
		return seller_dob;
	}
	public void setSeller_dob(String seller_dob) {
		this.seller_dob = seller_dob;
	}
	public String getSeller_contact() {
		return seller_contact;
	}
	public void setSeller_contact(String seller_contact) {
		this.seller_contact = seller_contact;
	}
	public String getSeller_city() {
		return seller_city;
	}
	public void setSeller_city(String seller_city) {
		this.seller_city = seller_city;
	}
	public String getSeller_prod_category() {
		return seller_prod_category;
	}
	public void setSeller_prod_category(String seller_prod_category) {
		this.seller_prod_category = seller_prod_category;
	}
	public String getSeller_prod_name() {
		return seller_prod_name;
	}
	public void setSeller_prod_name(String seller_prod_name) {
		this.seller_prod_name = seller_prod_name;
	}
	public String getSeller_ID() {
		return seller_ID;
	}
	public void setSeller_ID(String seller_ID) {
		this.seller_ID = seller_ID;
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
