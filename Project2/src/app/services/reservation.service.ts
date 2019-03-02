import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Room } from '../models/Room';
import { Reservation } from '../models/Reservation';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http :HttpClient,private ls :LoginService ) { }
  getAvailableRoomsUrl :string  = "http://ec2-54-172-178-2.compute-1.amazonaws.com:8080/Project2/getAvailableRooms.do";
  createAReservationUrl :string ="http://ec2-54-172-178-2.compute-1.amazonaws.com:8080/Project2/makeAReservation.do";
  getMyReservationsUrl :string = "http://ec2-54-172-178-2.compute-1.amazonaws.com:8080/Project2/getAllReservationsByCustomerId.do";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/x-www-form-urlencoded',
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  startDate :Date;
  endDate :Date;
  roomIds :Array<number>;
  roomsInCart :Array<Room>;
  madeAReservation :boolean = true;
  dailyBaseCost :number;
  numDaysReserved :number;
  orderTotal :number = 0;

  getRooms(start :Date, end :Date):Observable<Room>{
    console.log("getting reservations: " + start +"\n" + end);
    this.startDate = start;
    this.endDate = end;
    return this.http.get<Room>(this.getAvailableRoomsUrl+ "?start_Date="+start + "&end_Date="+end);
  }

  makeAReservation(username :string, start :Date, end :Date, selectedRoomIds :Array<number>) :Observable<string>{
    console.log("making reservation: " + start +"\n" + end+ "\n" + selectedRoomIds);
    console.log("username="+username + "&start_Date=" +start + "&end_Date=" + end + "&rooms="+selectedRoomIds);
    return this.http.post<string>(this.createAReservationUrl, "username="+username + "&start_Date=" +start + "&end_Date=" + end + "&rooms="+selectedRoomIds, this.httpOptions);
    // return null;
  }
  getMyReservations(userId :number):Observable<Reservation>{
    console.log("getting reservations: "+ this.getMyReservationsUrl);
    return this.http.post<Reservation>(this.getMyReservationsUrl, "customer_id="+userId, this.httpOptions);
  }

}
