import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { AuctionService } from '../auction.service';

@Component({
  selector: 'app-custreg',
  templateUrl: './custreg.component.html',
  styleUrls: ['./custreg.component.css']
})
export class CustregComponent implements OnInit {

  customer !: Customer;
  message !: string;

  constructor(private service: AuctionService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.customer = new Customer();
  }

  // tslint:disable-next-line: typedef
  createCustomer() {
    
    this.service.saveCustomer(this.customer)
    .subscribe(data => {
      this.message = data; // read message
      this.customer = new Customer(); // clear form
    }, error => {
      console.log(error);
    });
  }

  

}

