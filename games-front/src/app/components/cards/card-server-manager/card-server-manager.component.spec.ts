import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardServerManagerComponent } from './card-server-manager.component';

describe('CardServerManagerComponent', () => {
  let component: CardServerManagerComponent;
  let fixture: ComponentFixture<CardServerManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardServerManagerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardServerManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
