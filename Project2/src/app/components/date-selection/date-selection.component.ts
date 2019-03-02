import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service'
import { Observable } from 'rxjs';
import {Room} from 'src/app/models/Room';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-date-selection',
  templateUrl: './date-selection.component.html',
  styleUrls: ['./date-selection.component.css']
})
export class DateSelectionComponent implements OnInit {

  constructor(private rs :ReservationService, private ls :LoginService) {
   }

  ngOnInit() {  }

  today :Date = new Date();
  tomorrow :Date = new Date(this.today.getTime() + (1000 * 60 * 60 * 24));
  startDate :Date;
  endDate :Date;
  message :string;
  dailyCost :number = 50;
  daysReserved :number;
  rooms :Observable<Room> ;
  availableRooms :Room;
  selectedRoomIds :Array<number> = [];

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
      this.message = "";
      this.daysReserved = (new Date(this.endDate).getTime() - new Date(this.startDate).getTime()) / (1000 * 60 * 60 * 24);
      console.log(this.daysReserved);

      this.rooms.subscribe(
      (response)=>{console.log("successful call" + response);
          this.availableRooms = response
          console.log(this.availableRooms)
          this.rs.madeAReservation = true;
        },
      (response)=>{console.log("unsuccessful call" + response)}
      );
    }
  }

  addOrRemoveRoom(room_id :number) {
    console.log(room_id);
    if (this.selectedRoomIds.includes(room_id)) {
      console.log("deleting");
      // delete this.selectedRoomIds[room_id];
      for(let i = 0; i < this.selectedRoomIds.length; i++ ){
        if (this.selectedRoomIds[i] == room_id){
          this.selectedRoomIds.splice(i, 1);
          
        }
      }
    } else {
      console.log("adding")
      this.selectedRoomIds.push(room_id);
    }
    console.log(this.selectedRoomIds);
    this.setReservationCart(this.selectedRoomIds);
  }
  setReservationCart(rooms :Array<number>){
    this.rs.roomIds = rooms;
  }
}