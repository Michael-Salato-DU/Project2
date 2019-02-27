package model;

import java.util.ArrayList;
import java.util.List;

import model.Reservation;
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
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="rooms")
	List<Reservation> reservations = new ArrayList<Reservation>();

	
	public Room(int room_id, byte number_of_beds) {
		super();
		this.room_id = room_id;
		this.number_of_beds = number_of_beds;
	}
	
	public Room()
	{
		super();
		room_id = -1;
		number_of_beds = -1;
	}

	public int getRoom_id() {
		return room_id;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", number_of_beds=" + number_of_beds + "]";
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	

	
	
}
