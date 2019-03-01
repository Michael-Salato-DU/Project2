import { Component, OnInit } from '@angular/core';
import { CookieService } from 'angular2-cookie/core';
import { LoginService } from './services/login.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private ls :LoginService) {}

  ngOnInit() {
    
  }
 
  title = 'BADS Hotel';

  getCookie(key: string){
  }


}


