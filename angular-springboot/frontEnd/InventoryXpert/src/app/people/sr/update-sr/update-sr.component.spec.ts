import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSrComponent } from './update-sr.component';

describe('UpdateSrComponent', () => {
  let component: UpdateSrComponent;
  let fixture: ComponentFixture<UpdateSrComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateSrComponent]
    });
    fixture = TestBed.createComponent(UpdateSrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
