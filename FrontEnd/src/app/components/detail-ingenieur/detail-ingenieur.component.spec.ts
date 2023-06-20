import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailIngenieurComponent } from './detail-ingenieur.component';

describe('DetailIngenieurComponent', () => {
  let component: DetailIngenieurComponent;
  let fixture: ComponentFixture<DetailIngenieurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailIngenieurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailIngenieurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
