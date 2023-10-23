import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpaymentComponent } from './addpayment.component';

describe('AddpaymentComponent', () => {
  let component: AddpaymentComponent;
  let fixture: ComponentFixture<AddpaymentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddpaymentComponent]
    });
    fixture = TestBed.createComponent(AddpaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
