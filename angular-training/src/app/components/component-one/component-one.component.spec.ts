import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentOneComponent } from './ComponentOneComponent';

describe('ComponentOneComponent', () => {
  let component: ComponentOneComponent;
  let fixture: ComponentFixture<ComponentOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComponentOneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ComponentOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
