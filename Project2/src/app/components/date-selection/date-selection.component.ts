import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service'
import { Observable } from 'rxjs';
import {Room} from 'src/app/models/Room';

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

  rooms :Observable<Room> ;
  availableRoom :Room;

  submitDates() {
    this.rooms = this.rs.getRooms(this.startDate, this.endDate);
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

      this.rooms.subscribe(
      (response)=>{console.log("successful call" + response);
          this.availableRoom = response
          console.log(this.availableRoom)},
      (response)=>{console.log("unsuccessful call" + response)}
      );
    }
  }
}
