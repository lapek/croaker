import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-anon-header',
  templateUrl: './anon-header.component.html',
  styleUrls: ['./anon-header.component.css']
})
export class AnonHeaderComponent implements OnInit {
  title = 'Croaker';

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

}
