import { TestBed } from '@angular/core/testing';

import { DemandeClotureService } from './demande-cloture.service';

describe('DemandeClotureService', () => {
  let service: DemandeClotureService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemandeClotureService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
