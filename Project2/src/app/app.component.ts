import { Component, OnInit } from '@angular/core';
import { CookieService } from 'angular2-cookie/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private _cookieService:CookieService) {}

  ngOnInit() {
    
  }
 
  title = 'BADS Hotel';

  getCookie(key: string){
    return this._cookieService.get(key);
  }


}


