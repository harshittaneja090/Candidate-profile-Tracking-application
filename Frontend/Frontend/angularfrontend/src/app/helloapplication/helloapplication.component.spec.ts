import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloapplicationComponent } from './helloapplication.component';

describe('HelloapplicationComponent', () => {
  let component: HelloapplicationComponent;
  let fixture: ComponentFixture<HelloapplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HelloapplicationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HelloapplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
