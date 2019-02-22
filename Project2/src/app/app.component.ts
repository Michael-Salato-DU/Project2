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
   d = this.n.getDate();

   today :string = this.y + "-0" + this.m + "-" + this.d
  
   startDate :string;
   endDate :string;

   // when you click the submit button,
   // it will set endDate to startDate if endDate is undefined
   submitDates() {
     if (this.endDate == "undefined") {
       this.endDate = this.startDate;
     }
    
     console.log(this.endDate);
   }

}


