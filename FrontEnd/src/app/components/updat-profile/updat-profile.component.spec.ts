import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatProfileComponent } from './updat-profile.component';

describe('UpdatProfileComponent', () => {
  let component: UpdatProfileComponent;
  let fixture: ComponentFixture<UpdatProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatProfileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
