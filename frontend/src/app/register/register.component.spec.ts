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

  it('first form invalid when empty', () => {
    expect(component.firstRegisterForm.valid).toBeFalsy();
  });

  it('email field validity', () => {
    const email = component.secondRegisterForm.controls['email'];
    expect(email.valid).toBeFalsy();
  });

  it('email field required', () => {
    let errors = {};
    const email = component.secondRegisterForm.controls['email'];
    errors = email.errors || {};
    expect(errors['required']).toBeTruthy();
  });
});
