import {Component} from '@angular/core';
import {Router} from '@angular/router';

import {UserService} from '../_services';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import {animate, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  animations: [
    trigger('register-form', [
      transition(':enter', [
        style({transform: 'translateY(100%)'}),
        animate(120)
      ]),
      transition(':leave', [
        style({transform: 'translateY(0)'}),
        animate(120)
      ])
    ])
  ]
})
export class RegisterComponent {
  user: any = {};
  loading = false;
  firstRegisterForm: FormGroup;
  secondRegisterForm: FormGroup;

  constructor(private router: Router,
              private userService: UserService,
              public snackBar: MatSnackBar,
              public fb: FormBuilder) {
    this.firstRegisterForm = fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required]
    });
    this.secondRegisterForm = fb.group({
      'displayName': ['', Validators.required],
      'email': ['', Validators.compose([Validators.required, Validators.email])]
    });
  }

  register() {
    this.user = Object.assign(this.firstRegisterForm.value, this.secondRegisterForm.value);
    this.loading = true;
    this.userService.create(this.user)
      .subscribe(
        data => {
          this.router.navigate(['/login']);
          this.snackBar.open('Registration successful!', 'Ok', {
            duration: 2000
          });
        },
        error => {
          this.snackBar.open('Username already taken.', 'Close', {
            duration: 2000
          });
          this.loading = false;
        });
  }
}
