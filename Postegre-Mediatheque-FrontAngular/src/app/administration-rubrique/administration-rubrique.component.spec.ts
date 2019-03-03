import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrationRubriqueComponent } from './administration-rubrique.component';

describe('AdministrationRubriqueComponent', () => {
  let component: AdministrationRubriqueComponent;
  let fixture: ComponentFixture<AdministrationRubriqueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrationRubriqueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrationRubriqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
