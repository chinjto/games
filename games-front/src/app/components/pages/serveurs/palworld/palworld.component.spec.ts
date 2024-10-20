import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PalworldComponent } from './palworld.component';

describe('PalworldComponent', () => {
  let component: PalworldComponent;
  let fixture: ComponentFixture<PalworldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PalworldComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PalworldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
