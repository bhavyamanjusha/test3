import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductbidComponent } from './productbid.component';

describe('ProductbidComponent', () => {
  let component: ProductbidComponent;
  let fixture: ComponentFixture<ProductbidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductbidComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductbidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
