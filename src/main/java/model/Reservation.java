package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

public class Reservation {
	@Id
	@GeneratedValue
	private int reservation_id;
	private int customer_id;
	private long start_date;
	private long end_date;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Room> rooms = new ArrayList<Room>();

	/**
	 * @param reservation_id
	 * @param customer_id
	 * @param start_date
	 * @param end_date
	 * @param rooms
	 */
	public Reservation(int reservation_id, int customer_id, long start_date, long end_date, List<Room> rooms) {
		super();
		this.reservation_id = reservation_id;
		this.customer_id = customer_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.rooms = rooms;
	}
	
	public Reservation()
	{
		super();
		customer_id = -1;
		start_date = 0;
		end_date = 0;
		
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public long getStart_date() {
		return start_date;
	}

	public void setStart_date(long start_date) {
		this.start_date = start_date;
	}

	public long getEnd_date() {
		return end_date;
	}

	public void setEnd_date(long end_date) {
		this.end_date = end_date;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the customer_id
	 */
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
}
