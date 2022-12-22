import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CusteditComponent } from './custedit.component';

describe('CusteditComponent', () => {
  let component: CusteditComponent;
  let fixture: ComponentFixture<CusteditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CusteditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CusteditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
