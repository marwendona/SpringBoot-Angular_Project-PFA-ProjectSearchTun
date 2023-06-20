import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectsRequestsListComponent } from './projects-requests-list.component';

describe('ProjectsRequestsListComponent', () => {
  let component: ProjectsRequestsListComponent;
  let fixture: ComponentFixture<ProjectsRequestsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectsRequestsListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjectsRequestsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
