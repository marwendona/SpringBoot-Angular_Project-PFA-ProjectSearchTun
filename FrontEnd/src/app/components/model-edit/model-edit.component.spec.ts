import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelEditComponent } from './model-edit.component';

describe('ModelEditComponent', () => {
  let component: ModelEditComponent;
  let fixture: ComponentFixture<ModelEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModelEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModelEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
