import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {TOKEN_AUTH_PASSWORD, TOKEN_AUTH_USERNAME} from './auth.constant';

@Injectable()
export class AuthService {
  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    const body = 'grant_type=password&username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password);
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + btoa(TOKEN_AUTH_USERNAME + ':' + TOKEN_AUTH_PASSWORD)
    });

    return this.http.post<any>('/oauth/token', body, {headers: headers})
      .map(user => {
        if (user && user.access_token) {
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      });
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
}
