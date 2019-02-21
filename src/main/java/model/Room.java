package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private int room_id;
	private byte number_of_beds;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="reservation")
	ArrayList<Reservation> reservations;

	
	public Room(int room_id, byte number_of_beds, ArrayList<Reservation> reservations) {
		super();
		this.room_id = room_id;
		this.number_of_beds = number_of_beds;
		this.reservations = reservations;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public byte getNumber_of_beds() {
		return number_of_beds;
	}

	public void setNumber_of_beds(byte number_of_beds) {
		this.number_of_beds = number_of_beds;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
