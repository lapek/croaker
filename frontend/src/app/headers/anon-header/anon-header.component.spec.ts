import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AnonHeaderComponent} from './anon-header.component';
import {TestsModule} from '../../tests.module';

describe('AnonHeaderComponent', () => {
  let component: AnonHeaderComponent;
  let fixture: ComponentFixture<AnonHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AnonHeaderComponent],
      imports: [
        TestsModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnonHeaderComponent);
    fixture.detectChanges();
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
