import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CroaksComponent} from './croaks.component';
import {TestsModule} from '../tests.module';

describe('CroaksComponent', () => {
  let component: CroaksComponent;
  let fixture: ComponentFixture<CroaksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        CroaksComponent
      ],
      imports: [
        TestsModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CroaksComponent);
    fixture.detectChanges();
    component = fixture.componentInstance;
  });

  it('should create home component', () => {
    expect(component).toBeTruthy();
  });
});
