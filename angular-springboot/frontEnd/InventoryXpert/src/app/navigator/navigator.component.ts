import { Component } from '@angular/core';

@Component({
  selector: 'app-navigator',
  templateUrl: './navigator.component.html',
  styleUrls: ['./navigator.component.css']
})
export class NavigatorComponent {
  isFolded = false;

  toggleSidebar() {
    this.isFolded = !this.isFolded;
  }
}
