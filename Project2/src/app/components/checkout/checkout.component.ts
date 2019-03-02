import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private rs :ReservationService, private ls :LoginService) { }

  ngOnInit() {
  }
  sanityFunction(){
    console.log(this.rs.roomIds);
    console.log(this.ls.uname);
    console.log(this.rs.startDate + " | " +this.rs.endDate);
  }
  sendAReservation(){
    this.rs.makeAReservation(this.ls.uname, this.rs.startDate, this.rs.endDate, this.rs.roomIds)
    .subscribe(
      (response) => {console.log(response)}
    ,
    (response) => {console.log(response)}
    );
  }
}
