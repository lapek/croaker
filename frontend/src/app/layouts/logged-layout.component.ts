import {Component} from '@angular/core';

@Component({
  selector: 'app-logged-layout',
  template: `
    <app-logged-header></app-logged-header>
    <router-outlet></router-outlet>
  `,
  styles: []
})
export class LoggedLayoutComponent {
}
