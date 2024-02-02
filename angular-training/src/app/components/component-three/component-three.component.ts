import { Component } from '@angular/core';
import { SharingService } from '../../services/Sharing/sharing-service.service';
import { Router, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-component-three',
  standalone: true,
  imports: [RouterModule, MatButtonModule, FormsModule],
  providers: [RouterModule],
  templateUrl: './component-three.component.html',
  styleUrl: './component-three.component.css'
})
export class ComponentThreeComponent {
  data:any = "example";

  constructor(private router:Router,
      private sharingService:SharingService){}

  changeComponent(){
    console.log("changeComponent ");
      this.sharingService.setData(this.data);
  }

}
