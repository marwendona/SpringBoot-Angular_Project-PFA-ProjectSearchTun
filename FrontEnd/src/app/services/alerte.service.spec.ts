import { TestBed } from '@angular/core/testing';

import { AlerteService } from './alerte.service';

describe('AlerteService', () => {
  let service: AlerteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlerteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
