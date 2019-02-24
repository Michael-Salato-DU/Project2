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
  login(){

    if(((<HTMLSelectElement>document.getElementById('uname')).value.length < 6) || ((<HTMLSelectElement>document.getElementById('psw')).value.length <= 7)){
      alert("Username or Password have not met the requirements");
      alert(((<HTMLSelectElement>document.getElementById('uname')).value.length))
      alert(((<HTMLSelectElement>document.getElementById('psw')).value.length))

    }
    this.uname = ((<HTMLSelectElement>document.getElementById('uname')).value);
    this.psw =((<HTMLSelectElement>document.getElementById('psw')).value);
    console.log((<HTMLSelectElement>document.getElementById('uname')).value);
    console.log((<HTMLSelectElement>document.getElementById('psw')).value);
    this.sendLogin(this.uname,this.psw);
  }
  sendLogin(uname:string, psw: string){

  }

}
