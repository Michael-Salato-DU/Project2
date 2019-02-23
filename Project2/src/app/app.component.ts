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

  n =  new Date();
  y = this.n.getFullYear();
  m = this.n.getMonth() + 1;
  d :number = this.n.getDate();

  mformatted :string = ("0" + this.m).slice(-2);
  dformatted :string = ("0" + this.d).slice(-2);

  plzWork(d);
  plzWork(m);
  plzWork(num :number) {
    console.log("hi")
    // if (num < 10) {
    //   console.log("less than 10")
    // }
    // console.log("not less than 10")
  }

   today :string = this.y + "-" + this.mformatted + "-" + this.dformatted
  
   startDate :string = this.today;
   endDate :string; // preferably initialze to tommorow's date

   // when you click the submit button,
   // it will set endDate to startDate if endDate is undefined
   submitDates() {
     if (this.endDate == "undefined") {
       this.endDate = this.startDate;
     }
    
     console.log(this.endDate);
   }

}


