import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer';
import { Injectable } from '@angular/core';
import { stringify } from '@angular/core/src/util';

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



  sendLogin(uname:string, psw: string):Observable<string>{
  
    return  this.http.post<string>(this.loginUrl , "username="+uname + "&password="+psw, this.httpOptions)
    
  }
}
