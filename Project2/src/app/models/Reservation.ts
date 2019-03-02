import {Room} from 'src/app/models/Room';

export class Reservation{
    reservation_id :number;
    customer_id :number;
    start_date :Date;
    end_date :Date;
    reserved_rooms :Array<Room>;
    constructor(reservation_id :number, customer_id :number, start_date :Date, end_date :Date){
    this.reservation_id = reservation_id;
    this.customer_id = customer_id;
    this.start_date = start_date; 
    this.end_date = end_date; 
    }
}
