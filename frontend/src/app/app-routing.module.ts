import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AuthGuard, HomeGuard} from './_guards';
import {AnonLayoutComponent, FullscreenLayoutComponent, LoggedLayoutComponent} from './layouts/';
import {WallComponent} from './wall/wall.component';

const routes: Routes = [
  {
    path: '',
    component: FullscreenLayoutComponent,
    canActivate: [HomeGuard],
    children: [{path: '', component: HomeComponent}],
  },
  {
    path: 'login',
    component: AnonLayoutComponent,
    canActivate: [HomeGuard],
    children: [{path: '', component: LoginComponent}]
  },
  {
    path: 'register',
    component: AnonLayoutComponent,
    canActivate: [HomeGuard],
    children: [{path: '', component: RegisterComponent}]
  },
  {
    path: 'home',
    component: LoggedLayoutComponent,
    canActivate: [AuthGuard],
    children: [{path: '', component: WallComponent}]
  },

  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule {
}
