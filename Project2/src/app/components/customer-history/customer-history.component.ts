import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service'
import { LoginService } from 'src/app/services/login.service';
import { Reservation } from 'src/app/models/Reservation';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-customer-history',
  templateUrl: './customer-history.component.html',
  styleUrls: ['./customer-history.component.css']
})
export class CustomerHistoryComponent implements OnInit {

  constructor(private rs :ReservationService, private ls :LoginService) { }

  ngOnInit() {
  }
  beds :Array<number>  = [1,1,1,3,1,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3];
  reservedRooms :Observable<Reservation>;
  reservations :Reservation;
  showMyReservations(){
    console.log(this.beds.length);
    this.reservedRooms = this.rs.getMyReservations(this.ls.userId);
    this.reservedRooms.subscribe(
    //success
    (response)=>{
      console.log("pushing rooms" +JSON.stringify(response));
      this.reservations = response;
    },
    //failure
    (response)=>{
      
    });
  }
}
