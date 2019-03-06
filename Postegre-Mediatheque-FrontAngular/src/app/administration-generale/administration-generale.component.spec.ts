import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrationGeneraleComponent } from './administration-generale.component';

describe('AdministrationGeneraleComponent', () => {
  let component: AdministrationGeneraleComponent;
  let fixture: ComponentFixture<AdministrationGeneraleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrationGeneraleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrationGeneraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
