import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { CustomerEdit } from './customer_edit';
import { Seller } from './seller';

@Injectable({
    providedIn: 'root'
  })
  export class AuctionService {
  
    private basePathCustomer = 'http://localhost:8090/rest/customer';
    private basePathSeller = 'http://localhost:8090/rest/seller';
  
    constructor(private http: HttpClient) { }


    saveCustomer(customer: Customer): Observable<any> {
      console.log("customer_email==>"+customer.customer_email+" customer name==>"+customer.customer_name);
      return this.http.post(`${this.basePathCustomer}/save`, customer, {responseType: 'text'});
    }
    
    getOneCustomer(customerEdit_email: string): Observable<Customer> {
      return this.http.get<Customer>(`${this.basePathCustomer}/one/${customerEdit_email}`);
    }
  
    updateCustomer(customerEdit_email:string,customer: Customer): Observable<any> {
      return this.http.put(`${this.basePathCustomer}/modify/${customerEdit_email}`, customer, {responseType : 'text'});
    }

    saveSeller(seller: Seller): Observable<any> {
      console.log("seller_email==>"+seller.seller_email+" seller name==>"+seller.seller_name);
      return this.http.post(`${this.basePathSeller}/save`, seller, {responseType: 'text'});
    }


    getSellerID(seller_ID: string) : Observable<Seller> {
      return this.http.get<Seller>(`${this.basePathSeller}/one/${seller_ID}`);
    }


  
  
    
  }
  