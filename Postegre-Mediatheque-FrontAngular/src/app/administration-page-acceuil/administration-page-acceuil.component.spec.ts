import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrationPageAcceuilComponent } from './administration-page-acceuil.component';

describe('AdministrationPageAcceuilComponent', () => {
  let component: AdministrationPageAcceuilComponent;
  let fixture: ComponentFixture<AdministrationPageAcceuilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrationPageAcceuilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrationPageAcceuilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
