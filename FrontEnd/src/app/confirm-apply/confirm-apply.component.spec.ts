import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmApplyComponent } from './confirm-apply.component';

describe('ConfirmApplyComponent', () => {
  let component: ConfirmApplyComponent;
  let fixture: ComponentFixture<ConfirmApplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmApplyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmApplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
