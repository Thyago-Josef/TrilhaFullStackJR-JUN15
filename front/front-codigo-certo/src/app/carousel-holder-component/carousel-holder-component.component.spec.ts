import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouselHolderComponentComponent } from './carousel-holder-component.component';

describe('CarouselHolderComponentComponent', () => {
  let component: CarouselHolderComponentComponent;
  let fixture: ComponentFixture<CarouselHolderComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarouselHolderComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CarouselHolderComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
