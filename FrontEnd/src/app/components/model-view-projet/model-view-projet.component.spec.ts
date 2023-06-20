import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelViewProjetComponent } from './model-view-projet.component';

describe('ModelViewProjetComponent', () => {
  let component: ModelViewProjetComponent;
  let fixture: ComponentFixture<ModelViewProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModelViewProjetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModelViewProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
