import {Injectable} from "@angular/core";
import {AppUser} from "../Models/AppUser";
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";

export interface LoginData {
  email: string,
  password: string
}

@Injectable({providedIn: 'root'})
export class UserService {
  loggedInUser: AppUser | null = null;

  constructor(private httpClient: HttpClient) {
  }

  login(email: string, password: string):Observable<AppUser> {
    const loginData:LoginData = {email: email, password: password};
    return this.httpClient.post<AppUser>("http://localhost:8080/user/login",loginData)
      .pipe(tap(usr => this.loggedInUser = usr));

  }
}
