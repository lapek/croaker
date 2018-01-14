import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CroaksComponent } from './croaks.component';

describe('CroaksComponent', () => {
  let component: CroaksComponent;
  let fixture: ComponentFixture<CroaksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CroaksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CroaksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
