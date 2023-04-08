import { TestBed } from '@angular/core/testing';

import { DialogCreateService } from './dialog-create.service';

describe('DialogCreateService', () => {
  let service: DialogCreateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DialogCreateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
