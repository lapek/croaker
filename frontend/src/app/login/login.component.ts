import {Component, OnInit} from '@angular/core';
import {MatSnackBar} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

import {AuthService} from '../_services';

@Component({
  moduleId: module.id.toString(),
  templateUrl: 'login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any = {};
  loading = false;
  returnUrl: string;
  loginForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private authenticationService: AuthService,
              public snackBar: MatSnackBar,
              public fb: FormBuilder) {
    this.loginForm = fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required]
    });
  }

  ngOnInit() {
    this.authenticationService.logout();
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login() {
    this.user = this.loginForm.value;
    this.loading = true;
    this.authenticationService.login(this.user.username, this.user.password)
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
          this.snackBar.open('Successfully Logged in.', 'Ok', {
            duration: 2000
          });
        },
        error => {
          this.snackBar.open('Wrong username or password.', 'Close', {
            duration: 2000
          });
          this.loading = false;
        });
  }
}
