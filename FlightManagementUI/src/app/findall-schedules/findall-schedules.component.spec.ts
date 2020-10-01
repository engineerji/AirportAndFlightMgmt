import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindallSchedulesComponent } from './findall-schedules.component';

describe('FindallSchedulesComponent', () => {
  let component: FindallSchedulesComponent;
  let fixture: ComponentFixture<FindallSchedulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindallSchedulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindallSchedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
