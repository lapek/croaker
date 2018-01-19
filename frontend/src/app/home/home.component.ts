import {Component, OnInit} from '@angular/core';
import {UserService} from '../_services';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser: any;
  username = '';

  constructor(private userService: UserService) {
    this.userService.getSelf()
      .subscribe(
        data => {
          this.currentUser = data;
          this.username = this.currentUser.username;
        });
  }

  ngOnInit() {
  }

}
