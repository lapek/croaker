import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {LoggedHeaderComponent} from './logged-header.component';
import {TestsModule} from '../../tests.module';

describe('LoggedHeaderComponent', () => {
  let component: LoggedHeaderComponent;
  let fixture: ComponentFixture<LoggedHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LoggedHeaderComponent],
      imports: [
        TestsModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoggedHeaderComponent);
    fixture.detectChanges();
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
