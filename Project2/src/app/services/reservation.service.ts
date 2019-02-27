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
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/x-www-form-urlencoded',
      'X-Requested-With': 'XMLHttpRequest'
    })
  };
  
  getReservations(start :Date, end :Date):Observable<Array<Room>>{
    console.log(start +"\n" + end);
    return this.http.post<Array<Room>>(this.getAvailableRoomsUrl, "?start="+start + "end="+end, this.httpOptions);
  }
}
