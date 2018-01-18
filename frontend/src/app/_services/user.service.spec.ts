import {inject, TestBed} from '@angular/core/testing';

import {UserService} from './user.service';
import {TestsModule} from '../tests.module';

describe('UserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [TestsModule],
      providers: [UserService]
    });
  });

  it('should be created', inject([UserService], (service: UserService) => {
    expect(service).toBeTruthy();
  }));
});
