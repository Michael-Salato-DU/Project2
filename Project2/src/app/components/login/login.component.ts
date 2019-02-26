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
    if(this.uname.length < 6 || this.psw.length < 6){
      alert("Information not long enough");
    }
    else{
      console.log("sending login");
      this.ls.sendLogin(this.uname,this.psw).subscribe((response)=>{console.log("success"+response)},(response)=>{console.log("failure" + response)})
    }

  }  
}
