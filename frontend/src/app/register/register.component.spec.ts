import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {RegisterComponent} from './register.component';
import {TestsModule} from '../tests.module';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        RegisterComponent
      ],
      imports: [
        TestsModule
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    fixture.detectChanges();
    component = fixture.componentInstance;
  });

  it('should create register component', () => {
    expect(component).toBeTruthy();
  });
});
