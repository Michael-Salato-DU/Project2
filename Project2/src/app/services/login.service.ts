import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginUrl :string  = "http://ec2-54-172-178-2.compute-1.amazonaws.com:8080/Project2/login.do";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/x-www-form-urlencoded',
      'X-Requested-With': 'XMLHttpRequest'
    })
  };
  constructor(private http :HttpClient) { }


  uname :string;
  userId :number = 0;
  sendLogin(uname:string, psw: string):Observable<string>{
    
    return this.http.post<string>(this.loginUrl , "username="+uname + "&password="+psw, this.httpOptions)
    
  }
}
