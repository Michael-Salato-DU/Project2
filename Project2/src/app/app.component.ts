import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor() {}



  ngOnInit() {
    
  }
 
  title = 'BADS Hotel';

  // getting today's date
  n = new Date();
  y = this.n.getFullYear();
  m = this.n.getMonth() + 1;
  d = this.n.getDate();

  // reformating the month and day to be two digit 
  mformatted :string = ("0" + this.m).slice(-2);
  dformatted :string = ("0" + this.d).slice(-2);

  // today is always today's date
  today :string = this.y + "-" + this.mformatted + "-" + this.dformatted;
  // startDate will start as today, but will change based on the input
  startDate :string = this.today;
  // preferably initialze to tommorow's date when startDate get initialzed
  endDate :string; 


   // when you click the submit button,
   // it will set endDate to startDate if endDate is undefined
   
 
   submitDates() {
     if (this.endDate == null) {
       this.endDate = this.startDate.substring(0,8)+(+this.startDate.substring(8,10)+1);
     }
     /*  

      Here you can get the Arrival Date as (startDate) which is a string formated yyyy-mm-dd

      Also you back Departure Date as (endDate) which is a string formated yyyy-mm-dd

     */
   }

}


