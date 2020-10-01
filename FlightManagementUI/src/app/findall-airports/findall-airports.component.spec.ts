import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindallAirportsComponent } from './findall-airports.component';

describe('FindallAirportsComponent', () => {
  let component: FindallAirportsComponent;
  let fixture: ComponentFixture<FindallAirportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindallAirportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindallAirportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
