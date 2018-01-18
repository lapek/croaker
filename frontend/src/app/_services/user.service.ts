import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from '../_models/index';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<User[]>('http://localhost:8080/api/users');
  }

  // getById(id: number) {
  //   return this.http.get('http://localhost:8080/api/users/' + id);
  // }

  create(user: User) {
    return this.http.post('http://localhost:8080/api/user/signup', user);
  }

  // update(user: User) {
  //   return this.http.put('http://localhost:8080/api/users/' + user.id, user);
  // }

  // delete(id: number) {
  //   return this.http.delete('/api/users/' + id);
  // }
}
