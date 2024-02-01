import { Component, OnInit } from '@angular/core';
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
export class ComponentTwoComponent implements OnInit {
  receivedMessage: string | undefined;
  private subscription: Subscription | undefined;

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.subscription = this.dataService.message$.subscribe((message) => {
      this.receivedMessage = message;
      console.log('Component Two received message:', this.receivedMessage);
    });
  }

  ngOnDestroy() {
    // Unsubscribe to avoid memory leaks
    this.subscription?.unsubscribe();
  }
}
