import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from '../_models';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {
  }

  getSelf() {
    return this.http.get('/api/user/me');
  }

  getAll() {
    return this.http.get<User[]>('/api/user/all');
  }

  // getById(id: number) {
  //   return this.http.get('http://localhost:8080/api/users/' + id);
  // }

  create(user: User) {
    return this.http.post('/api/user/signup', user);
  }

  // update(user: User) {
  //   return this.http.put('http://localhost:8080/api/users/' + user.id, user);
  // }

  // delete(id: number) {
  //   return this.http.delete('/api/users/' + id);
  // }
}
