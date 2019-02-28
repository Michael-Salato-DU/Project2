import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'
import { Subscriber, Observable } from 'rxjs';
import { CookieService } from 'angular2-cookie/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private ls :LoginService,private _cookieService:CookieService ) { }

  ngOnInit() {
  }
  uname: string;
  psw: string;
  a: string;
  login(){
    if(this.uname.length < 4 || this.psw.length < 4){
      alert("Information not long enough");
    }
    else{
      console.log("sending login");
     
      this.ls.sendLogin(this.uname,this.psw).subscribe((response)=>{this.a = response;this._cookieService.put('cid', this.a);
      console.log("success "+response)},(response)=>{console.log("failure " + response)})
      }


  }
  
}
