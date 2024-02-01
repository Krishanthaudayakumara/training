import { Component } from '@angular/core';
import { DataService } from '../../services/data/data.service';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-component-one',
  standalone: true,
  imports: [MatButtonModule, FormsModule],
  providers: [DataService],
  templateUrl: './component-one.component.html',
  styleUrl: './component-one.component.css',
})
export class ComponentOneComponent {
  message: string = '';

  constructor(private dataService: DataService) {}

  sendMessage() {
    this.dataService.sendData(this.message);
    console.log('Sent message from one: ', this.message);
  }
}
