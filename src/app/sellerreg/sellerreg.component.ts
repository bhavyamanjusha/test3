import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Seller } from '../seller';
import { AuctionService } from '../auction.service';

@Component({
  selector: 'app-sellerreg',
  templateUrl: './sellerreg.component.html',
  styleUrls: ['./sellerreg.component.css']
})
export class SellerregComponent implements OnInit {

  seller !: Seller;
  message !: string;

  constructor(private service: AuctionService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.seller = new Seller();
  }

  // tslint:disable-next-line: typedef
  createSeller() {
    
    this.service.saveSeller(this.seller)
    .subscribe(data => {
      this.message = data; // read message
      this.seller = new Seller(); // clear form
    }, error => {
      console.log(error);
    });
  }

  

}

