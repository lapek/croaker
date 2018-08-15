import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable()
export class HomeGuard implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (!localStorage.getItem('currentUser')) {
      // not logged in so return true
      return true;
    }

    // logged in so redirect to home page with the return url
    this.router.navigate(['/home'], {queryParams: {returnUrl: state.url}});
    return false;
  }
}
