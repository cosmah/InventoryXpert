import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRecieptComponent } from './create-reciept.component';

describe('CreateRecieptComponent', () => {
  let component: CreateRecieptComponent;
  let fixture: ComponentFixture<CreateRecieptComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateRecieptComponent]
    });
    fixture = TestBed.createComponent(CreateRecieptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
