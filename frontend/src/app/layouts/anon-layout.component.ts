import {Component} from '@angular/core';

@Component({
  selector: 'app-anon-layout',
  template: `
    <app-anon-header></app-anon-header>
    <router-outlet></router-outlet>
  `,
  styles: []
})
export class AnonLayoutComponent {
}
