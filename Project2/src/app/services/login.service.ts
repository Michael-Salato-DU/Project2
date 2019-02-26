import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  registerUrl :string  = "http://ec2-52-15-141-97.us-east-2.compute.amazonaws.com:8080/Project2/login.do";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/x-www-form-urlencoded',
      'X-Requested-With': 'XMLHttpRequest'
    })
  };
  constructor(private http :HttpClient) { }


  sendLogin(uname:string, psw: string):Observable<Customer>{
    // this.lCustomer.first_name = uname;
    // console.log("psw: " + this.lCustomer.password);
    // console.log("name: " +this.lCustomer.first_name);

    return this.http.get<Customer>(this.registerUrl + "?username="+uname + "&password="+psw, this.httpOptions);
  }
}
