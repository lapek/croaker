import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../_services';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-logged-header',
  templateUrl: './logged-header.component.html',
  styleUrls: ['./logged-header.component.css']
})
export class LoggedHeaderComponent implements OnInit {
  title = 'Croaker';

  constructor(private router: Router,
              private authenticationService: AuthService,
              public snackBar: MatSnackBar) {
  }

  ngOnInit() {
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['']);
    this.snackBar.open('Successfully Logged out.', 'Ok', {
      duration: 2000
    });
  }
}
