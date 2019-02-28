import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-date-selection',
  templateUrl: './date-selection.component.html',
  styleUrls: ['./date-selection.component.css']
})
export class DateSelectionComponent implements OnInit {

  constructor(private rs :ReservationService) { }

  ngOnInit() { }

  today :Date = new Date();
  tomorrow :Date = new Date(this.today.getTime() + (1000 * 60 * 60 * 24));
  startDate :Date;
  endDate :Date;
  message :string;

  submitDates() :any {
    if( this.endDate == null || this.startDate == null){
      // alert("enddate not picked");
      this.message = "You must pick both arrival and departure.";
    }
    else if( this.endDate < this.startDate){
      this.message = "You cannot arrive after you leave."; 
    }
    else if ( this.endDate == this.startDate){
      this.message = "You must depart on at least the next day.";
    }
    else if ( this.startDate < this.endDate){
      return this.rs.getRooms(this.startDate, this.endDate)
      .subscribe(
      (response)=>{console.log("successful call" + response)},
      (response)=>{console.log("unsuccessful call" + response)}
      );
    }
  }
}
