import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuctionService } from '../auction.service';
import { Customer } from '../customer';
import { CustomerEdit } from '../customer_edit';




@Component({
  selector: 'app-custedit',
  templateUrl: './custedit.component.html',
  styleUrls: ['./custedit.component.css']
})
export class CusteditComponent implements OnInit {

  customer !: Customer;
  customer_email !: string
  message!: string

  constructor(private service: AuctionService, private router: Router, private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.customer_email = this.activatedRoute.snapshot.params['customer_email'];

    this.service.getOneCustomer(this.customer_email).subscribe(
      data => {
      this.customer = data;
      console.log(this.customer);
    }, error => {
      console.log(error);
    });
  }
  
  updateCustomer() {
    this.service.updateCustomer(this.customer_email,this.customer)
    .subscribe(data => {
      this.message = data; // read message
      this.customer = new Customer(); // clear form
    }, error => {
      console.log(error);
    });

  }


}
