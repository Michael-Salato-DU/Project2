import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service'

@Component({
  selector: 'app-date-selection',
  templateUrl: './date-selection.component.html',
  styleUrls: ['./date-selection.component.css']
})
export class DateSelectionComponent implements OnInit {

  constructor(private rs :ReservationService) { }

  ngOnInit() {
  }
  today :Date = new Date();
  tomorrow :Date = new Date(this.today.getTime() + (1000 * 60 * 60 * 24));
  startDate :Date = new Date();
  endDate :Date;
  submitDates() {
    if( this.endDate == null){
      alert("enddate not picked");
    }
    else if( this.endDate < this.startDate){
      alert("endDate greater than StartDate");
    }
    else if ( this.endDate == this.startDate){
      alert("you must depart on at least the next day")
    }
    else if ( this.startDate < this.endDate){
      this.rs.getReservations(this.startDate, this.endDate);
    }
  }
}
