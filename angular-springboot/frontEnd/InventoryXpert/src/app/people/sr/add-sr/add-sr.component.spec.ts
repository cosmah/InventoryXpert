import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSrComponent } from './add-sr.component';

describe('AddSrComponent', () => {
  let component: AddSrComponent;
  let fixture: ComponentFixture<AddSrComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddSrComponent]
    });
    fixture = TestBed.createComponent(AddSrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
