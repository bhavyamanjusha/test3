import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuctionService } from '../auction.service';
import { Seller } from '../seller';

@Component({
  selector: 'app-sellerdetails',
  templateUrl: './sellerdetails.component.html',
  styleUrls: ['./sellerdetails.component.css']
})
export class SellerdetailsComponent implements OnInit {
  seller!: Seller;
  seller_ID !: string;


  constructor(private service: AuctionService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.seller_ID = this.activatedRoute.snapshot.params['seller_ID'];

    this.service.getSellerID(this.seller_ID).subscribe(
      data => {
      this.seller = data;
      console.log(this.seller);
    }, error => {
      console.log(error);
    });
  }


  }


