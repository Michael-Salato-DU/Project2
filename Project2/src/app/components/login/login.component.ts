import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private ls :LoginService ) { }

  ngOnInit() {
  }
  uname: string;
  psw: string;
  a: string;
  responseText: string = null;
  login(){
    if(this.uname.length < 4 || this.psw.length < 4){
      alert("Information not long enough");
    }
    else{
      console.log("sending login");
     
      this.ls.sendLogin(this.uname,this.psw)
      .subscribe((response)=>{
        this.a = response;
        if(response != "Unsuccessful logon attempt"){
          console.log("number");
          this.ls.userId = parseInt(response);
          this.ls.uname = this.uname;
        }
        console.log("success");
        console.log(response); 
        this.responseText = "You have logged on.";
      },
      (response)=>{
        console.log("failure " + response);
      this.responseText = response})

      }


  }
  
}
