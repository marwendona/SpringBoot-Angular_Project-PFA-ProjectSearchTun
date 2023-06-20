import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChartIngComponent } from './chart-ing.component';

describe('ChartIngComponent', () => {
  let component: ChartIngComponent;
  let fixture: ComponentFixture<ChartIngComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChartIngComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChartIngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
