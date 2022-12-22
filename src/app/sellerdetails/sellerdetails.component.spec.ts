import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerdetailsComponent } from './sellerdetails.component';

describe('SellerdetailsComponent', () => {
  let component: SellerdetailsComponent;
  let fixture: ComponentFixture<SellerdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SellerdetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
