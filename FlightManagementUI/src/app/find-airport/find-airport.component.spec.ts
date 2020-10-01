import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindAirportComponent } from './find-airport.component';

describe('FindAirportComponent', () => {
  let component: FindAirportComponent;
  let fixture: ComponentFixture<FindAirportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindAirportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
