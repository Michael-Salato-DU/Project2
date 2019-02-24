// import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
// import { Observable } from 'rxjs';
// import { HttpHeaders } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  //this url will be the .do
  registerUrl :string  = "";

  constructor(private http :HttpClient) { }

  sendRegister(customer :Customer):any{
    return this.http.post(this.registerUrl, customer);
  }
  
}
