import {Injectable} from '@angular/core';
import {Http,Response,Headers,RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import { User } from './user.interface';
import { ResponseData } from './response.interface';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';


@Injectable()
export class UserService{
private userServiceUrl='http://localhost:9001/api/user/';//url to web API
private headers = new Headers({'Content-Type': 'application/json'});
constructor(private http:Http){}
validateUser(model: User): Promise<String> {
        return this.http
          .post(this.userServiceUrl, JSON.stringify(model), {headers: this.headers})
          .toPromise()
          .then(res => res.json() as String)
          .catch(this.handleError);
      }
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}