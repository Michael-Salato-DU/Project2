import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  //this url will be the .do
  registerUrl :string  = "http://ec2-52-15-141-97.us-east-2.compute.amazonaws.com:8080/Project2/register.do";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/x-www-form-urlencoded',
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  constructor(private http :HttpClient) { }
  
  sendRegister(customer :Customer):Observable<string>{
    console.log(customer);
    return this.http.post<string>(this.registerUrl , "?first_name="+customer.first_name +"&last_name=" + customer.last_name + "&username="+customer.username + "&password="+customer.password + "&email=" + customer.email +"&phone="+customer.phone_number + "&address="+customer.address, this.httpOptions);
  }
  
}
