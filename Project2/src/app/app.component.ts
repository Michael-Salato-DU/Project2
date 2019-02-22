import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BADS Hotel';

  n =  new Date();
  y = this.n.getFullYear();
  m = this.n.getMonth() + 1;
  ad = this.n.getDate();
  dd =  this.n.getDate() +1;
  adate = this.y + "-" + this.m + "-" + this.ad
  ddate = this.y + "-" + this.m + "-" + this.dd

  //date :any = new Date().toJSON().split('T')[0];

}


