import { Component } from '@angular/core';
import { DataService } from '../../services/data/data.service';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-component-one',
  standalone: true,
  imports: [MatButtonModule],
  providers: [DataService],
  templateUrl: './component-one.component.html',
  styleUrl: './component-one.component.css'
})
export class ComponentOneComponent {

  constructor(private dataService: DataService) {}



 
  ngOnInit() {
    this.dataService.sendMessage('Component One initialized!');
    console.log('Component One initialized!');
  }

}
