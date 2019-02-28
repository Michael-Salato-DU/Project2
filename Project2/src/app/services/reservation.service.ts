import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Room } from '../models/Room';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http :HttpClient) { }
  getAvailableRoomsUrl :string  = "http://ec2-52-15-141-97.us-east-2.compute.amazonaws.com:8080/Project2/getAvailableRooms.do";
  testAvailableRoomsUrlTest :string = "https://api.myjson.com/bins/rhah6";
  createAReservationUrl :string;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/x-www-form-urlencoded',
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  getRooms(start :Date, end :Date):Observable<Room>{
    console.log("getting reservations: " + start +"\n" + end);
    return this.http.get<Room>(this.testAvailableRoomsUrlTest+ "?start_Date="+start + "&end_Date="+end);
  }

  makeAReservation(start :Date, end :Date):any{
    console.log("making reservation: (return is null)" + start +"\n" + end);
    return null;
  }

}
