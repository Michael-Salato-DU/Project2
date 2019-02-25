import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private ls :LoginService) { }

  ngOnInit() {
  }
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
    this.ls.sendLogin(this.uname,this.psw);
  }  
}
