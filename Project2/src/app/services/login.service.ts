import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  login(){

    if(((<HTMLSelectElement>document.getElementById('uname')).value.length < 6) || ((<HTMLSelectElement>document.getElementById('psw')).value.length <= 7)){
      alert("Username or Password have not met the requirements");
      alert(((<HTMLSelectElement>document.getElementById('uname')).value.length))
      alert(((<HTMLSelectElement>document.getElementById('psw')).value.length))

    }
    console.log((<HTMLSelectElement>document.getElementById('uname')).value);
    console.log((<HTMLSelectElement>document.getElementById('psw')).value);
  }
}

