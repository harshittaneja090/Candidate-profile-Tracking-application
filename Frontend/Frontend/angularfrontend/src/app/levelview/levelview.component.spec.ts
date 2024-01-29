import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LevelviewComponent } from './levelview.component';

describe('LevelviewComponent', () => {
  let component: LevelviewComponent;
  let fixture: ComponentFixture<LevelviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LevelviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LevelviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
