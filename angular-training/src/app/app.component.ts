import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { StudentComponent } from './components/student/student.component';
import {HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ComponentOneComponent } from './components/component-one/component-one.component';
import { ComponentTwoComponent } from './components/component-two/component-two.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, StudentComponent, CommonModule, ComponentOneComponent, ComponentTwoComponent, RouterOutlet, RouterLink, RouterLinkActive],
  providers: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
  
})
export class AppComponent {
  message: string = 'Hello, Angular!';
  messageToChild: string = 'Hello, Child Component!';
  messageFromChild: string | undefined;

  receiveMessage($event: string | undefined) {
    this.messageFromChild = $event;
    console.log("recieved message from child: " + $event);
  }
}
