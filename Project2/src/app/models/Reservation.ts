export class Reservation{
    reservation_id :number;
    customer_id :number;
    start_date :number;
    end_date :number;
    constructor(reservation_id :number, customer_id :number, start_date :number, end_date :number){
    this.reservation_id = reservation_id;
    this.customer_id = customer_id;
    this.start_date = start_date; 
    this.end_date = end_date; 
    }
}