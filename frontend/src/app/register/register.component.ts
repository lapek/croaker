import {Component} from '@angular/core';
import {Router} from '@angular/router';

import {UserService} from '../_services';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: any = {};
  loading = false;
  registerForm: FormGroup;

  constructor(private router: Router,
              private userService: UserService,
              public snackBar: MatSnackBar,
              public fb: FormBuilder) {
    this.registerForm = fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required]
    });
  }

  register() {
    this.user = this.registerForm.value;
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
