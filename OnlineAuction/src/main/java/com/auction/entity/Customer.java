package com.auction.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	private String customer_email;
	private String customer_name;
	private String customer_dob;
	private String customer_contact;
	private String customer_city;
	private String cust_prod_category;
	private String cust_prod_name;
	private String cust_ID;
	
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_dob() {
		return customer_dob;
	}
	public void setCustomer_dob(String customer_dob) {
		this.customer_dob = customer_dob;
	}
	public String getCustomer_contact() {
		return customer_contact;
	}
	public void setCustomer_contact(String customer_contact) {
		this.customer_contact = customer_contact;
	}
	public String getCustomer_city() {
		return customer_city;
	}
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	public String getCust_prod_category() {
		return cust_prod_category;
	}
	public void setCust_prod_category(String cust_prod_category) {
		this.cust_prod_category = cust_prod_category;
	}
	public String getCust_prod_name() {
		return cust_prod_name;
	}
	public void setCust_prod_name(String cust_prod_name) {
		this.cust_prod_name = cust_prod_name;
	}
	public String getCust_ID() {
		return cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		this.cust_ID = cust_ID;
	}
	
	
	
	
	
	
	
	

	
	
	
}
