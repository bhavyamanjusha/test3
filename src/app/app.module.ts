import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SellerComponent } from './seller/seller.component';
import { RouterModule, Routes } from '@angular/router';
import { SellerregComponent } from './sellerreg/sellerreg.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { SellerdetailsComponent} from './sellerdetails/sellerdetails.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductdetailsComponent } from './productdetails/productdetails.component';
import { CustregComponent} from './custreg/custreg.component';
import { CusteditComponent} from './custedit/custedit.component';
import { PlacebidsComponent } from './placebids/placebids.component';
import { AboutpageComponent } from './aboutpage/aboutpage.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

const appRoutes: Routes =[		
  {path:'Seller' , component:SellerComponent},
  {path:'Sellerreg', component:SellerregComponent , pathMatch:'full'},
  {path:'Edit',component:AddproductComponent, pathMatch:'full'},
  {path:'Deleteproduct',component:AddproductComponent, pathMatch:'full'},
  {path:'Biddetails',component:AddproductComponent, pathMatch:'full'},
  {path:'Deleteseller',component:SellerdetailsComponent, pathMatch:'full'},
  {path:'Sellerbyid',component:SellerdetailsComponent,pathMatch:'full'},
  {path:'Customer' , component:CustomerComponent,pathMatch:'full'},
  {path:'Cusreg',component:CustregComponent,pathMatch:'full'},
  {path:'Cusedit/:customer_email',component:CusteditComponent,pathMatch:'full'},
  {path:'Updatecusdetails',component:CusteditComponent,pathMatch:'full'},
  {path:'Prodbyid',component:ProductdetailsComponent,pathMatch:'full'},
  {path:'prodbycat',component:ProductdetailsComponent,pathMatch:'full'},
  {path:'placebid',component:PlacebidsComponent,pathMatch:'full'},
  {path:'viewallbids',component:PlacebidsComponent,pathMatch:'full'},
  {path:'About',component:AboutpageComponent,pathMatch:'full'}


  ];


@NgModule({
  declarations: [
    AppComponent,
    SellerComponent,
    SellerregComponent,
    AddproductComponent,
    CustomerComponent,
    ProductdetailsComponent,
    CustregComponent,
    CusteditComponent,
    PlacebidsComponent,
    AboutpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
