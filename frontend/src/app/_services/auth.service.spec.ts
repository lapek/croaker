import {inject, TestBed} from '@angular/core/testing';

import {AuthService} from './auth.service';
import {TestsModule} from '../tests.module';

describe('AuthService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [TestsModule],
      providers: [AuthService]
    });
  });

  it('should be created', inject([AuthService], (service: AuthService) => {
    expect(service).toBeTruthy();
  }));
});
