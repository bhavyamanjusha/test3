import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerregComponent } from './sellerreg.component';

describe('SellerregComponent', () => {
  let component: SellerregComponent;
  let fixture: ComponentFixture<SellerregComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SellerregComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellerregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
