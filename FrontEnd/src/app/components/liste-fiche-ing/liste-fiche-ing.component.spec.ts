import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeFicheIngComponent } from './liste-fiche-ing.component';

describe('ListeFicheIngComponent', () => {
  let component: ListeFicheIngComponent;
  let fixture: ComponentFixture<ListeFicheIngComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeFicheIngComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeFicheIngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
