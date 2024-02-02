import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { SharingService } from '../../services/Sharing/sharing-service.service';

@Component({
  selector: 'app-component-four',
  standalone: true,
  imports: [],
  providers:[],
  templateUrl: './component-four.component.html',
  styleUrl: './component-four.component.css'
})
export class ComponentFourComponent {

  data:any;

  constructor(private router:Router,
      private sharingService:SharingService){}

  ngOnInit(){
      this.data = this.sharingService.getData();
  }
}
