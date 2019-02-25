import { Injectable } from '@angular/core';
// import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // within constructor ( private http:HttpClient )
  constructor() { }
  uname: string;
  psw: string;
  
  sendLogin(uname:string, psw: string){

  }
}
