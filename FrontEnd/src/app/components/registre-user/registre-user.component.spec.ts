import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistreUserComponent } from './registre-user.component';

describe('RegistreUserComponent', () => {
  let component: RegistreUserComponent;
  let fixture: ComponentFixture<RegistreUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistreUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistreUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
