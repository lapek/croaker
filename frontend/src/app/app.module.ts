import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FlexLayoutModule} from '@angular/flex-layout';

import {MaterialModule} from './material.module';
import {AppComponent} from './app.component';
import {CroaksComponent} from './croaks/croaks.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home/home.component';
import {AppRoutingModule} from './app-routing.module';
import {AuthGuard, HomeGuard} from './_guards';
import {AuthService, UserService} from './_services';
import {JwtInterceptor} from './_helpers/jwt.interceptor';
import {AnonLayoutComponent, FullscreenLayoutComponent, LoggedLayoutComponent} from './layouts';
import {AnonHeaderComponent, LoggedHeaderComponent} from './headers';
import {WallComponent} from './wall/wall.component';

@NgModule({
  declarations: [
    AppComponent,
    AnonHeaderComponent,
    LoggedHeaderComponent,
    AnonLayoutComponent,
    LoggedLayoutComponent,
    FullscreenLayoutComponent,
    CroaksComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    WallComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    HttpClientModule,
    FlexLayoutModule,
    AppRoutingModule
  ],
  providers: [
    AuthGuard,
    HomeGuard,
    AuthService,
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
