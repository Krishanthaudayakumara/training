import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DataService } from '../../services/data/data.service';
import { ComponentOneComponent } from '../component-one/component-one.component';

@Component({
  selector: 'app-component-two',
  standalone: true,
  imports: [],
  providers: [DataService],
  templateUrl: './component-two.component.html',
  styleUrl: './component-two.component.css',
})
export class ComponentTwoComponent implements OnDestroy {
  receivedData: string = '';
  private subscription: Subscription | undefined;

  constructor(@Inject(DataService) private dataService: DataService) {
  this.subscription = this.dataService.data$.subscribe((data) => {
      this.receivedData = data;
      console.log('received data:', this.receivedData);
    });
  }

  ngOnDestroy() {
    this.subscription?.unsubscribe();
  }
}
